package com.bh.androidx_material_samples.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.Text
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt
import androidx.compose.ui.tooling.preview.Preview

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun SwipeableSample() {
    // Draw a slider-like composable consisting of a red square moving along a
    // black background, with three states: "A" (min), "B" (middle), and "C" (max).
    val width = 350.dp
    val squareSize = 50.dp

    val swipeableState = rememberSwipeableState("A")
    val sizePx = with(LocalDensity.current) { (width - squareSize).toPx() }
    val anchors = mapOf(0f to "A", sizePx / 2 to "B", sizePx to "C")

    Box(
        modifier = Modifier
            .width(width)
            .swipeable(
                state = swipeableState,
                anchors = anchors,
                thresholds = { _, _ -> FractionalThreshold(0.5f) },
                orientation = Orientation.Horizontal
            )
            .background(Color.Black)
    ) {
        Box(
            Modifier
                .offset {
                    IntOffset(
                        swipeableState.offset.value.roundToInt(), 0
                    )
                }
                .size(squareSize)
                .background(Color.Red),
            contentAlignment = Alignment.Center) {
            Text(
                swipeableState.currentValue,
                color = Color.White,
                fontSize = 24.sp
            )
        }
    }
}

@Preview
@Composable
fun SwipeableSamplePreview() {
    SwipeableSample()
}

