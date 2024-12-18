package com.dara.weathertracker.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.unit.sp
import com.dara.weathertracker.R
import com.dara.weathertracker.ui.theme.BlackText


@Composable
fun EmptyStateWidget() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.7f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        Text(
            stringResource(R.string.no_city_selected),
            fontSize = 30.sp,
            fontWeight = SemiBold,
            color = BlackText
        )
        Text(
            stringResource(R.string.please_search_for_a_city),
            fontSize = 15.sp,
            fontWeight = SemiBold,
            color = BlackText
        )
    }
}
