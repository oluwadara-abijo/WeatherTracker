package com.dara.weathertracker.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.dara.weathertracker.ui.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    modifier: Modifier
) {
    val viewModel: HomeViewModel = hiltViewModel()
    val uiState by viewModel.uiState
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        if (!uiState.errorMessage.isNullOrEmpty()) {
            LaunchedEffect(key1 = uiState.errorMessage) {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar(uiState.errorMessage!!)
                }
            }
        }

        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
        ) {

            SearchBarWidget(
                searchInput = uiState.searchInput,
                onSearchInputChanged = { viewModel.updateSearchInput(it) },
                onSearchClicked = { viewModel.getWeatherData(it) })

            when {
                uiState.isEmptyState -> EmptyStateWidget()

                uiState.isLoading ->
                    ProgressBar(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        loading = true
                    )

                uiState.shouldShowCard ->
                    if (uiState.weatherData != null)
                        CityCard(
                            cityName = uiState.weatherData!!.cityName,
                            temperature = uiState.weatherData!!.temperature,
                            icon = uiState.weatherData!!.icon
                        ) {viewModel.updateSearchMode(false) }

            }

        }
    }

}

