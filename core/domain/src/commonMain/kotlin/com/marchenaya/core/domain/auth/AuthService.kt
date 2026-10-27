package com.marchenaya.core.domain.auth

import com.marchenaya.core.domain.util.DataError
import com.marchenaya.core.domain.util.EmptyResult

interface AuthService {
    suspend fun register(
        email: String,
        username: String,
        password: String
    ): EmptyResult<DataError.Remote>
}