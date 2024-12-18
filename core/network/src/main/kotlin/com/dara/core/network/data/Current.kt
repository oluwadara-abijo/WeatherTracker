package com.dara.core.network.data

import kotlinx.serialization.Serializable

@Serializable
data class Current(
    val cloud: Double,
    val condition: Condition,
    val dewpoDouble_c: Double? = null,
    val dewpoDouble_f: Double? = null,
    val feelslike_c: Double,
    val feelslike_f: Double,
    val gust_kph: Double,
    val gust_mph: Double,
    val heatindex_c: Double,
    val heatindex_f: Double,
    val humidity: Double,
    val is_day: Double,
    val last_updated: String,
    val last_updated_epoch: Double,
    val precip_in: Double,
    val precip_mm: Double,
    val pressure_in: Double,
    val pressure_mb: Double,
    val temp_c: Double,
    val temp_f: Double,
    val uv: Double,
    val vis_km: Double,
    val vis_miles: Double,
    val wind_degree: Double,
    val wind_dir: String,
    val wind_kph: Double,
    val wind_mph: Double,
    val windchill_c: Double,
    val windchill_f: Double
)