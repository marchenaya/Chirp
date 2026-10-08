package com.marchenaya.core.designsystem.components.buttons

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.marchenaya.core.designsystem.icons.Add
import com.marchenaya.core.designsystem.icons.ChirpIcons
import com.marchenaya.core.designsystem.theme.ChirpTheme

@Composable
fun ChirpFloatingActionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    ) {
        content()
    }
}

@Preview
@Composable
private fun ChirpFloatingActionButtonPreview() {
    ChirpTheme {
        ChirpFloatingActionButton(
            onClick = {}
        ) {
            Icon(
                imageVector = ChirpIcons.Add,
                contentDescription = null
            )
        }
    }
}