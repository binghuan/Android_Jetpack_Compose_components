package com.bh.androidx_material_samples.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.OutlinedButton
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LinearProgressIndicatorSample() {
    var progress by remember { mutableFloatStateOf(0.1f) }
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec,
        label = ""
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        LinearProgressIndicator(progress = animatedProgress)
        Spacer(Modifier.requiredHeight(30.dp))
        OutlinedButton(onClick = { if (progress < 1f) progress += 0.1f }) {
            Text(
                "Increase"
            )
        }
    }
}

@Composable
fun CircularProgressIndicatorSample() {
    var progress by remember { mutableFloatStateOf(0.1f) }
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec,
        label = ""
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        CircularProgressIndicator(progress = animatedProgress)
        Spacer(Modifier.requiredHeight(30.dp))
        OutlinedButton(onClick = { if (progress < 1f) progress += 0.1f }) {
            Text(
                "Increase"
            )
        }
    }
}

@Preview
@Composable
fun LinearProgressIndicatorSamplePreview() {
    LinearProgressIndicatorSample()
}

@Preview
@Composable
fun CircularProgressIndicatorSamplePreview() {
    CircularProgressIndicatorSample()
}
