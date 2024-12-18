package com.dara.core.network.utils

import com.dara.core.network.R
import com.dara.core.network.data.ServerError
import kotlinx.serialization.json.Json
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

/**
 * Handles network errors and returns appropriate error message.
 */

interface ErrorHandler {

    fun getErrorMessage(e: Throwable): String
}

class ErrorHandlerImpl @Inject constructor(
    private val stringProvider: StringProvider
) : ErrorHandler {
    override fun getErrorMessage(e: Throwable): String {
        return when (e) {
            is UnknownHostException -> stringProvider.getString(R.string.no_internet_connection)
            is SocketTimeoutException -> stringProvider.getString(R.string.request_timed_out)
            is HttpException -> handleHttpException(e)
            else -> stringProvider.getString(R.string.something_went_wrong)
        }
    }

    private fun handleHttpException(exception: HttpException): String {
        return when (exception.code()) {
            400 -> {
                val errorBody = exception.response()?.errorBody()?.string()
                parseServerError(errorBody) ?: stringProvider.getString(R.string.bad_request_error)
            }
            401, 403 -> stringProvider.getString(R.string.invalid_api_key)
            else -> stringProvider.getString(R.string.something_went_wrong)
        }
    }


    private fun parseServerError(errorBody: String?): String? {
        return try {
            errorBody?.let {
                val serverError = Json.decodeFromString<ServerError>(it)
                when (serverError.error.code) {
                    1006 -> stringProvider.getString(R.string.invalid_location)
                    else -> serverError.error.message
                }
            }
        } catch (e: Exception) {
            null
        }
    }
}
