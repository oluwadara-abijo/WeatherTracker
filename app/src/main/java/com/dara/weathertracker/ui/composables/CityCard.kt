package com.dara.weathertracker.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale.Companion.FillWidth
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.dara.weathertracker.ui.theme.GreyBackground

@Composable
fun CityCard(cityName: String, temperature: String, icon: String, onClick: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 32.dp)
            .clickable { onClick() }
            .background(
                color = GreyBackground,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 32.dp, vertical = 16.dp)
    ) {
        Column {
            Text(cityName, fontWeight = FontWeight.SemiBold, fontSize = 30.sp)
            Row {
                Text(temperature, fontWeight = FontWeight.Medium, fontSize = 60.sp)
                Spacer(Modifier.width(8.dp))
                Text("°", fontSize = 18.sp, modifier = Modifier.padding(top = 12.dp))

            }
        }
        AsyncImage(
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterVertically),
            model = icon,
            contentDescription = null,
        )
    }
}
