package com.marchenaya.core.designsystem.icons

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.marchenaya.core.designsystem.theme.ChirpTheme

val ChirpIcons.ArrowBack: ImageVector by lazy {
    ImageVector.Builder(
        name = "ArrowBack",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f,
        autoMirror = true
    ).apply {
        path(fill = SolidColor(Color.Black)) {
            moveTo(7.83f, 13f)
            lineToRelative(5.6f, 5.6f)
            lineTo(12f, 20f)
            lineTo(4f, 12f)
            lineTo(12f, 4f)
            lineToRelative(1.43f, 1.4f)
            lineTo(7.83f, 11f)
            horizontalLineTo(20f)
            verticalLineToRelative(2f)
            horizontalLineTo(7.83f)
            close()
        }
    }.build()
}

@Composable
@Preview
fun ArrowBackIconPreview() {
    ChirpTheme {
        Icon(
            imageVector = ChirpIcons.ArrowBack,
            contentDescription = null
        )
    }
}
