package com.dara.weathertracker.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dara.core.network.WeatherRepository
import com.dara.core.network.data.WeatherData
import com.dara.core.network.utils.ErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val errorHandler: ErrorHandler,
) : ViewModel() {

    private val _uiState = mutableStateOf(HomeUiState())
    val uiState: State<HomeUiState> = _uiState

    fun getWeatherData(cityName: String) {
        updateState(isEmptyState = false, isLoading = true)

        viewModelScope.launch {
            val result = repository.getWeatherData(cityName)
            result.fold(
                onSuccess = { data ->
                    updateState(isLoading = false, weatherData = data, shouldShowCard = true)
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

    fun updateSearchMode(shouldShowCard: Boolean) {
        updateState(shouldShowCard = shouldShowCard)
    }

    // Updates the current state of the UI
    private fun updateState(
        isEmptyState: Boolean? = null,
        isLoading: Boolean? = null,
        errorMessage: String? = null,
        searchInput: String? = null,
        shouldShowCard: Boolean? = null,
        weatherData: WeatherData? = null
    ) {
        _uiState.value = _uiState.value.copy(
            isEmptyState = isEmptyState ?: _uiState.value.isEmptyState,
            isLoading = isLoading ?: _uiState.value.isLoading,
            errorMessage = errorMessage ?: _uiState.value.errorMessage,
            searchInput = searchInput ?: _uiState.value.searchInput,
            shouldShowCard = shouldShowCard ?: _uiState.value.shouldShowCard,
            weatherData = weatherData ?: _uiState.value.weatherData

        )
    }
}
