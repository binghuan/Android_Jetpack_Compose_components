package com.bh.androidx_material_samples.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.IconToggleButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun IconButtonSample() {
    IconButton(onClick = { /* doSomething() */ }) {
        Icon(Icons.Filled.Favorite, contentDescription = "Localized description")
    }
}

@Composable
fun IconToggleButtonSample() {
    var checked by remember { mutableStateOf(false) }

    IconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
        val tint by animateColorAsState(if (checked) Color(0xFFEC407A) else Color(0xFFB0BEC5))
        Icon(Icons.Filled.Favorite, contentDescription = "Localized description", tint = tint)
    }
}

@Preview
@Composable
fun IconButtonSamplePreview() {
    IconButtonSample()
}

@Preview
@Composable
fun IconToggleButtonSamplePreview() {
    IconToggleButtonSample()
}