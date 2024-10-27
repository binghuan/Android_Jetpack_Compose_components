package com.bh.androidx_material_samples.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ContentAlphaSample() {
    // Note the alpha values listed below are the values for light theme. The values are slightly
    // different in dark theme to provide proper contrast against the background.
    Column {
        Text(
            "No content alpha applied - uses the default content alpha set by MaterialTheme - " + "87% alpha"
        )
        CompositionLocalProvider(LocalContentAlpha provides 1.00f) {
            Text("1.00f alpha applied - 100% alpha")
        }
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
            Text("High content alpha applied - 87% alpha")
        }
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text("Medium content alpha applied - 60% alpha")
        }
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
            Text("Disabled content alpha applied - 38% alpha")
        }
    }
}

@Preview
@Composable
fun ContentAlphaSamplePreview() {
    ContentAlphaSample()
}

