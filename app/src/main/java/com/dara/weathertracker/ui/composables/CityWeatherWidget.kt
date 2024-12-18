package com.dara.weathertracker.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.dara.core.network.data.WeatherData
import com.dara.weathertracker.R
import com.dara.weathertracker.ui.theme.GreyBackground
import com.dara.weathertracker.ui.theme.GreyText
import com.dara.weathertracker.ui.theme.SecondaryText

@Composable
fun CityWeatherWidget(weatherData: WeatherData) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 72.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .size(150.dp),
            model = weatherData.icon,
            contentDescription = null,
        )
        Row {
            Text(weatherData.cityName, fontSize = 30.sp, fontWeight = FontWeight.SemiBold)
            Spacer(Modifier.width(4.dp))
            Icon(
                painterResource(R.drawable.ic_location),
                contentDescription = null,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
        Row {
            Text(weatherData.temperature, fontWeight = FontWeight.Medium, fontSize = 70.sp)
            Spacer(Modifier.width(8.dp))
            Text("°", fontSize = 18.sp, modifier = Modifier.padding(top = 12.dp))
        }
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 36.dp, horizontal = 48.dp)
                .background(color = GreyBackground, shape = RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            WeatherColumn("Humidity", "${weatherData.humidity}%")
            WeatherColumn("UV", weatherData.uvIndex)
            WeatherColumn("Feels like", "${weatherData.feelsLike}°")
        }
    }
}

@Composable
fun WeatherColumn(title: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(title, fontWeight = FontWeight.Medium, fontSize = 12.sp, color = GreyText)
        Text(value, fontWeight = FontWeight.Medium, fontSize = 15.sp, color = SecondaryText)
    }
}
