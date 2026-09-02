package com.marchenaya.core.data.networking

import com.marchenaya.core.data.logging.KermitLogger
import com.marchenaya.core.domain.util.DataError
import com.marchenaya.core.domain.util.Result
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.serialization.SerializationException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

actual suspend fun <T> platformSafeCall(
    execute: suspend () -> HttpResponse,
    handleResponse: suspend (HttpResponse) -> Result<T, DataError.Remote>
): Result<T, DataError.Remote> {
    return try {
        val response = execute()
        handleResponse(response)
    } catch (e: UnknownHostException) {
        KermitLogger.error("Unknown host: DNS resolution failed, device likely offline", e)
        Result.Failure(DataError.Remote.NO_INTERNET)
    } catch (e: UnresolvedAddressException) {
        KermitLogger.error("Unresolved host address: device likely offline", e)
        Result.Failure(DataError.Remote.NO_INTERNET)
    } catch (e: ConnectException) {
        KermitLogger.error("Connection failed: unable to reach server", e)
        Result.Failure(DataError.Remote.NO_INTERNET)
    } catch (e: SocketTimeoutException) {
        KermitLogger.error("Socket timed out waiting for server response", e)
        Result.Failure(DataError.Remote.REQUEST_TIMEOUT)
    } catch (e: HttpRequestTimeoutException) {
        KermitLogger.error("HTTP request timed out waiting for server response", e)
        Result.Failure(DataError.Remote.REQUEST_TIMEOUT)
    } catch (e: SerializationException) {
        KermitLogger.error("Failed to serialize/deserialize network payload", e)
        Result.Failure(DataError.Remote.SERIALIZATION)
    } catch (e: Exception) {
        currentCoroutineContext().ensureActive()
        KermitLogger.error("Unexpected error during network call", e)
        Result.Failure(DataError.Remote.UNKNOWN)
    }
}