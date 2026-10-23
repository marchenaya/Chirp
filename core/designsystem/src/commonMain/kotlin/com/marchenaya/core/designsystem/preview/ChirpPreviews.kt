package com.marchenaya.core.designsystem.preview

import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_NO
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_TYPE_NORMAL
import androidx.compose.ui.tooling.preview.Devices.DESKTOP
import androidx.compose.ui.tooling.preview.Devices.FOLDABLE
import androidx.compose.ui.tooling.preview.Devices.PHONE
import androidx.compose.ui.tooling.preview.Devices.TABLET
import androidx.compose.ui.tooling.preview.Preview

@Retention(AnnotationRetention.BINARY)
@Preview(
    name = "Phone · Light",
    device = PHONE,
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL,
    showSystemUi = true
)
@Preview(
    name = "Phone · Dark",
    device = PHONE,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL,
    showSystemUi = true
)
@Preview(
    name = "Phone Landscape · Light",
    device = "spec:width=411dp,height=891dp,orientation=landscape,dpi=420",
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL,
    showSystemUi = true,
    showBackground = true,
    // Mirrors LightColorScheme.background (ChirpBrand1000); real screens get it from their Scaffold
    backgroundColor = 0xFF092E2D
)
@Preview(
    name = "Phone Landscape · Dark",
    device = "spec:width=411dp,height=891dp,orientation=landscape,dpi=420",
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL,
    showSystemUi = true,
    showBackground = true,
    // Mirrors DarkColorScheme.background (ChirpBase1000)
    backgroundColor = 0xFF101C28
)
@Preview(
    name = "Unfolded Foldable · Light",
    device = FOLDABLE,
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL,
    showSystemUi = true
)
@Preview(
    name = "Unfolded Foldable · Dark",
    device = FOLDABLE,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL,
    showSystemUi = true
)
@Preview(
    name = "Tablet · Light",
    device = "spec:width=1280dp,height=800dp,dpi=240,orientation=portrait",
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL,
    showSystemUi = true
)
@Preview(
    name = "Tablet · Dark",
    device = "spec:width=1280dp,height=800dp,dpi=240,orientation=portrait",
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL,
    showSystemUi = true
)
@Preview(
    name = "Tablet Landscape · Light",
    device = TABLET,
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL,
    showSystemUi = true
)
@Preview(
    name = "Tablet Landscape · Dark",
    device = TABLET,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL,
    showSystemUi = true
)
@Preview(
    name = "Desktop · Light",
    device = DESKTOP,
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL,
    showSystemUi = true
)
@Preview(
    name = "Desktop · Dark",
    device = DESKTOP,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL,
    showSystemUi = true
)
annotation class ChirpPreviewAdaptive

@Retention(AnnotationRetention.BINARY)
@Preview(name = "Light", showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Preview(
    name = "Dark",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    backgroundColor = 0xFF101C28
)
annotation class ChirpPreviewLightDark
