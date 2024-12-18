package com.dara.weathertracker.ui

import com.dara.core.network.data.WeatherData


data class HomeUiState(
    val isEmptyState: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val searchInput: String = "",
    val shouldShowCard: Boolean = false,
    val shouldShowData: Boolean = false,
    val weatherData: WeatherData? = null,
    val selectedCity: String? = null,
)
