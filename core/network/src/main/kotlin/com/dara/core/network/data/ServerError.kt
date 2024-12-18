package com.dara.core.network.data

import kotlinx.serialization.Serializable

@Serializable
data class ServerError(
    val error: ErrorDetail
) {
    @Serializable
    data class ErrorDetail(
        val code: Int,
        val message: String
    )
}
