package com.dara.core.network.data

import kotlinx.serialization.Serializable

@Serializable
data class WeatherApiModel(
    val current: Current,
    val location: Location
)
