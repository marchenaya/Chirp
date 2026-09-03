package com.marchenaya.core.presentation.util

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowSizeClass.Companion.HEIGHT_DP_EXPANDED_LOWER_BOUND
import androidx.window.core.layout.WindowSizeClass.Companion.HEIGHT_DP_MEDIUM_LOWER_BOUND
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_EXPANDED_LOWER_BOUND
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_MEDIUM_LOWER_BOUND

private const val WIDTH_DP_LARGE_LOWER_BOUND = 1200

@Composable
fun currentDeviceConfiguration(): DeviceConfiguration {
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
    return DeviceConfiguration.fromWindowSizeClass(windowSizeClass)
}

enum class DeviceConfiguration {
    MOBILE_PORTRAIT,
    MOBILE_LANDSCAPE,
    TABLET_PORTRAIT,
    TABLET_LANDSCAPE,
    DESKTOP;

    companion object {
        fun fromWindowSizeClass(windowSizeClass: WindowSizeClass): DeviceConfiguration {
            return with(windowSizeClass) {
                when {
                    minWidthDp >= WIDTH_DP_LARGE_LOWER_BOUND -> DESKTOP

                    (minWidthDp in WIDTH_DP_EXPANDED_LOWER_BOUND until WIDTH_DP_LARGE_LOWER_BOUND)
                            && (minHeightDp in HEIGHT_DP_MEDIUM_LOWER_BOUND until HEIGHT_DP_EXPANDED_LOWER_BOUND) -> TABLET_LANDSCAPE

                    (minWidthDp in WIDTH_DP_MEDIUM_LOWER_BOUND until WIDTH_DP_EXPANDED_LOWER_BOUND)
                            && minHeightDp >= HEIGHT_DP_EXPANDED_LOWER_BOUND -> TABLET_PORTRAIT

                    minHeightDp < HEIGHT_DP_MEDIUM_LOWER_BOUND -> MOBILE_LANDSCAPE

                    else -> MOBILE_PORTRAIT
                }
            }
        }
    }
}
