package com.dara.core.network

import com.dara.core.network.data.WeatherData
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherApi: WeatherApi
) {
    suspend fun getWeatherData(cityName: String): Result<WeatherData> {
        return try {
            // Get server response
            val serverResponse = weatherApi.fetchWeatherData(cityName)
            // Map to UI model
            val repositories = serverResponse.toWeatherData()
            Result.success(repositories)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
