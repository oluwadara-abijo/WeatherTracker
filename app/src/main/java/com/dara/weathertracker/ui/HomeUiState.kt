package com.dara.weathertracker.ui

import com.dara.core.network.data.WeatherData


data class HomeUiState(
    val isEmptyState: Boolean = true,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val searchInput: String = "",
    val shouldShowCard: Boolean = false,
    val shouldShowData: Boolean = true,
    val weatherData: WeatherData? = null
)
