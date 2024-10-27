package com.bh.androidx_material_samples.ui


import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CardSample() {
    Card { Text("Card Content") }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ClickableCardSample() {
    var count by remember { mutableStateOf(0) }
    Card(onClick = { count++ }) { Text("Clickable card content with count: $count") }
}

@Preview
@Composable
fun CardSamplePreview() {
    CardSample()
}

@Preview
@Composable
fun ClickableCardSamplePreview() {
    ClickableCardSample()
}