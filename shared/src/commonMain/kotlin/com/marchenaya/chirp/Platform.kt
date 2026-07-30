package com.marchenaya.chirp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform