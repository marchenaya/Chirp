package com.marchenaya.chirp

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.marchenaya.auth.presentation.register.RegisterScreenRoot
import com.marchenaya.core.designsystem.theme.ChirpTheme

@Preview
@Composable
fun App() {
    ChirpTheme {
        RegisterScreenRoot()
    }
}