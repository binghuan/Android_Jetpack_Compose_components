package com.bh.androidx_material_samples.ui

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SurfaceSample() {
    Surface(color = MaterialTheme.colors.background) { Text("Text color is `onBackground`") }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ClickableSurfaceSample() {
    var count by remember { mutableStateOf(0) }
    Surface(onClick = { count++ }, color = MaterialTheme.colors.background) {
        Text("Clickable surface Text with `onBackground` color and count: $count")
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SelectableSurfaceSample() {
    var selected by remember { mutableStateOf(false) }
    Surface(
        selected = selected,
        onClick = { selected = !selected },
        color = MaterialTheme.colors.background
    ) {
        Text(
            text = if (selected) "Selected" else "Not Selected",
            textAlign = TextAlign.Center
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ToggleableSurfaceSample() {
    var checked by remember { mutableStateOf(false) }
    Surface(
        checked = checked,
        onCheckedChange = { checked = !checked },
        color = if (checked) {
            MaterialTheme.colors.primary
        } else {
            MaterialTheme.colors.background
        }
    ) {
        Text(text = if (checked) "ON" else "OFF", textAlign = TextAlign.Center)
    }
}

@Preview
@Composable
fun SurfaceSamplePreview() {
    SurfaceSample()
}

@Preview
@Composable
fun ClickableSurfaceSamplePreview() {
    ClickableSurfaceSample()
}

@Preview
@Composable
fun SelectableSurfaceSamplePreview() {
    SelectableSurfaceSample()
}

@Preview
@Composable
fun ToggleableSurfaceSamplePreview() {
    ToggleableSurfaceSample()
}
