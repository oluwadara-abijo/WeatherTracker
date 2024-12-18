package com.dara.core.network

import com.dara.core.network.data.WeatherApiModel
import com.dara.core.network.data.WeatherData
import com.dara.core.network.utils.formatIconUrl

fun WeatherApiModel.toWeatherData(): WeatherData = WeatherData(
    cityName = location.name,
    temperature = current.temp_c.toInt().toString(),
    humidity = current.humidity.toInt().toString(),
    uvIndex = current.uv.toInt().toString(),
    feelsLike = current.feelslike_c.toInt().toString(),
    icon = current.condition.icon.formatIconUrl()
)
