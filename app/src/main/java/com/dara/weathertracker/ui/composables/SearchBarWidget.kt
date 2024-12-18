package com.dara.weathertracker.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.dara.weathertracker.R
import com.dara.weathertracker.ui.theme.GreyBackground
import com.dara.weathertracker.ui.theme.GreyText
import com.dara.weathertracker.ui.theme.IconColor


@Composable
fun SearchBarWidget(
    searchInput: String = "",
    onSearchInputChanged: (String) -> Unit,
    onSearchClicked: (String) -> Unit
) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = GreyBackground,
            focusedContainerColor = GreyBackground,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(16.dp),
        value = searchInput,
        onValueChange = { onSearchInputChanged(it) },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = { onSearchClicked(searchInput) }),
        placeholder = {
            Text(
                text = stringResource(R.string.search),
                color = GreyText,
                maxLines = 1,
            )
        },
        trailingIcon = {
            Icon(
                modifier = Modifier.clickable { onSearchClicked(searchInput) },
                imageVector = Icons.Filled.Search,
                contentDescription = null,
                tint = IconColor
            )
        },
        singleLine = true
    )
}
