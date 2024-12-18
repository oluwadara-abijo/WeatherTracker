package com.dara.core.network

import com.dara.core.network.data.WeatherApiModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("current.json")
    suspend fun fetchWeatherData(@Query("q") cityName: String): WeatherApiModel
}
