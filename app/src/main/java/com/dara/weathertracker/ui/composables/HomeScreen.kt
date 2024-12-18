package com.dara.weathertracker.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    modifier: Modifier
) {
    Column(modifier = modifier
        .fillMaxSize()
        .padding(12.dp)) {
        SearchBarWidget("") { }
        EmptyStateWidget()
    }
}

