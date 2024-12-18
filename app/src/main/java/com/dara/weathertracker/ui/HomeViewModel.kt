package com.dara.weathertracker.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dara.core.network.WeatherRepository
import com.dara.core.network.data.WeatherData
import com.dara.core.network.utils.ErrorHandler
import com.dara.weathertracker.data.CityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val cityRepository: CityRepository,
    private val errorHandler: ErrorHandler,
) : ViewModel() {

    private val _uiState = mutableStateOf(HomeUiState())
    val uiState: State<HomeUiState> = _uiState

    init {
        viewModelScope.launch {
            cityRepository.selectedCity.collect { city ->
                updateState(selectedCity = city)
                if (city != null) {
                    getWeatherData(city, false)
                    updateState(shouldShowData = true)
                } else {
                    updateState(isEmptyState = true)
                }
            }
        }
    }

    fun getWeatherData(cityName: String, isForSearch : Boolean) {
        updateState(isEmptyState = false, isLoading = true)

        viewModelScope.launch {
            val result = repository.getWeatherData(cityName)
            result.fold(
                onSuccess = { data ->
                    updateState(isLoading = false, weatherData = data, shouldShowCard = isForSearch)
                },
                onFailure = { exception ->
                    updateState(
                        isLoading = false,
                        errorMessage = errorHandler.getErrorMessage(exception)
                    )
                })
        }
    }

    fun updateSearchInput(searchInput: String) {
        updateState(searchInput = searchInput)
    }

    fun toggleSearchMode(shouldShowCityWeather: Boolean) {
        updateState(shouldShowCard = !shouldShowCityWeather, shouldShowData = shouldShowCityWeather)
        if (shouldShowCityWeather) {
            saveSelectedCity(cityName = uiState.value.searchInput)
        }
    }

    private fun saveSelectedCity(cityName: String) {
        viewModelScope.launch {
            cityRepository.saveSelectedCity(cityName)
        }
        updateState(selectedCity = cityName)
    }

    // Updates the current state of the UI
    private fun updateState(
        isEmptyState: Boolean? = null,
        isLoading: Boolean? = null,
        errorMessage: String? = null,
        searchInput: String? = null,
        shouldShowCard: Boolean? = null,
        shouldShowData: Boolean? = null,
        weatherData: WeatherData? = null,
        selectedCity: String? = null,
    ) {
        _uiState.value = _uiState.value.copy(
            isEmptyState = isEmptyState ?: _uiState.value.isEmptyState,
            isLoading = isLoading ?: _uiState.value.isLoading,
            errorMessage = errorMessage ?: _uiState.value.errorMessage,
            searchInput = searchInput ?: _uiState.value.searchInput,
            shouldShowCard = shouldShowCard ?: _uiState.value.shouldShowCard,
            shouldShowData = shouldShowData ?: _uiState.value.shouldShowData,
            weatherData = weatherData ?: _uiState.value.weatherData,
            selectedCity = selectedCity ?: _uiState.value.selectedCity
        )
    }
}
