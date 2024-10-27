package com.bh.androidx_material_samples.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RangeSlider
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SliderSample() {
    var sliderPosition by remember { mutableStateOf(0f) }
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(text = "%.2f".format(sliderPosition))
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
    }
}


@Composable
fun StepsSliderSample() {
    var sliderPosition by remember { mutableStateOf(0f) }
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(text = sliderPosition.roundToInt().toString())
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..100f,
            onValueChangeFinished = {
                // launch some business logic update with the state you hold
                // viewModel.updateSelectedSliderValue(sliderPosition)
            },
            // Only allow multiples of 10. Excluding the endpoints of `valueRange`,
            // there are 9 steps (10, 20, ..., 90).
            steps = 9,
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colors.secondary,
                activeTrackColor = MaterialTheme.colors.secondary
            )
        )
    }
}


@Composable
@OptIn(ExperimentalMaterialApi::class)
fun RangeSliderSample() {
    var sliderPosition by remember { mutableStateOf(0f..100f) }
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        val rangeStart = "%.2f".format(sliderPosition.start)
        val rangeEnd = "%.2f".format(sliderPosition.endInclusive)
        Text(text = "$rangeStart .. $rangeEnd")
        RangeSlider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..100f,
            onValueChangeFinished = {
                // launch some business logic update with the state you hold
                // viewModel.updateSelectedSliderValue(sliderPosition)
            },
        )
    }
}


@Composable
@OptIn(ExperimentalMaterialApi::class)
fun StepRangeSliderSample() {
    var sliderPosition by remember { mutableStateOf(0f..100f) }
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        val rangeStart = sliderPosition.start.roundToInt()
        val rangeEnd = sliderPosition.endInclusive.roundToInt()
        Text(text = "$rangeStart .. $rangeEnd")
        RangeSlider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..100f,
            onValueChangeFinished = {
                // launch some business logic update with the state you hold
                // viewModel.updateSelectedSliderValue(sliderPosition)
            },
            // Only allow multiples of 10. Excluding the endpoints of `valueRange`,
            // there are 9 steps (10, 20, ..., 90).
            steps = 9,
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colors.secondary,
                activeTrackColor = MaterialTheme.colors.secondary
            )
        )
    }
}

@Preview
@Composable
fun SliderSamplePreview() {
    SliderSample()
}

@Preview
@Composable
fun StepsSliderSamplePreview() {
    StepsSliderSample()
}

@Preview
@Composable
fun RangeSliderSamplePreview() {
    RangeSliderSample()
}

@Preview
@Composable
fun StepRangeSliderSamplePreview() {
    StepRangeSliderSample()
}
