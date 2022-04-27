package com.bored.app.core.data.utils

import com.bored.app.R
import com.bored.app.core.domain.utils.JsonParser
import com.bored.app.core.presentation.utils.UiText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

inline fun <reified T> unwrap(parser: JsonParser, crossinline apiCall: suspend () -> T): Flow<Result<T>> =
    flow {
        emit(Result.Loading())
        try {
            val data = apiCall()
            emit(Result.Success(data))
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(
                Result.Error(
                data = parser.fromJson<T>(e.response()?.errorBody()?.charStream().toString(), T::class.java),
                uiText = when {
                    e.code() == 503 -> {
                        UiText.StringResource(R.string.general_message_server_maintenance)
                    }
                    (500..550).contains(e.code()) -> {
                        UiText.StringResource(R.string.general_message_server_error)
                    }
                    else -> {
                        UiText.StringResource(R.string.general_message_cannot_retrieve_data)
                    }
                }
            ))
        } catch (e: SocketTimeoutException) {
            e.printStackTrace()
            emit(Result.Error(uiText = UiText.StringResource(R.string.general_message_timeout_error)))
        } catch (e: IOException) {
            e.printStackTrace()
            emit(Result.Error(uiText = UiText.StringResource(R.string.general_message_network_error)))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Result.Error(uiText = UiText.unknownError()))
        }
    }