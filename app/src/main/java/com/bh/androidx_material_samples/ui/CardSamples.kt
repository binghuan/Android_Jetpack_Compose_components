package com.bh.androidx_material_samples.ui

import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CardSample() {
    Card { Text("Card Content") }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClickableCardSample() {
    var count by remember { mutableIntStateOf(0) }
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
