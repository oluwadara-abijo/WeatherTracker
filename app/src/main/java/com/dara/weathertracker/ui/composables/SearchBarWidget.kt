package com.dara.weathertracker.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dara.weathertracker.R
import com.dara.weathertracker.ui.theme.GreyBackground
import com.dara.weathertracker.ui.theme.GreyText
import com.dara.weathertracker.ui.theme.IconColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarWidget(
    searchTerm: String,
    onSearchInputChanged: (String) -> Unit,
) {
    SearchBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = SearchBarDefaults.colors(containerColor = GreyBackground),
        shape = RoundedCornerShape(16.dp),
        query = searchTerm,
        onQueryChange = onSearchInputChanged,
        onSearch = {},
        active = false,
        onActiveChange = {},
        placeholder = { Text(text = stringResource(R.string.search), color = GreyText) },
        trailingIcon =
        { Icon(imageVector = Icons.Filled.Search, contentDescription = null, tint = IconColor) },
    ) {
    }
}
