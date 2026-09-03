package com.marchenaya.core.data.networking

import com.marchenaya.core.data.BuildKonfig
import com.marchenaya.core.domain.logging.ChirpLogger
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class HttpClientFactory(
    private val chirpLogger: ChirpLogger
) {

    fun create(engine: HttpClientEngine): HttpClient {
        return HttpClient(engine) {
            install(ContentNegotiation) {
                json(
                    json = Json {
                        ignoreUnknownKeys = true

                    }
                )
            }
            install(HttpTimeout) {
                socketTimeoutMillis = TIMEOUT_MILLIS
                requestTimeoutMillis = TIMEOUT_MILLIS
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        chirpLogger.debug(message)
                    }
                }
                level = LogLevel.ALL
            }
            install(WebSockets) {
                pingIntervalMillis = PING_INTERVAL_MILLIS
            }
            defaultRequest {
                header(API_KEY_HEADER, BuildKonfig.API_KEY)
                contentType(ContentType.Application.Json)
            }
        }
    }

    private companion object {
        const val TIMEOUT_MILLIS = 20_000L
        const val PING_INTERVAL_MILLIS = 20_000L
        const val API_KEY_HEADER = "x-api-key"
    }

}