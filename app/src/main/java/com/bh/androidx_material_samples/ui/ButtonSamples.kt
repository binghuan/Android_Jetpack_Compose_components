package com.bh.androidx_material_samples.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ButtonSample() {
    Button(onClick = { /* Do something! */ }) { Text("Button") }
}

@Composable
fun OutlinedButtonSample() {
    OutlinedButton(onClick = { /* Do something! */ }) { Text("Outlined Button") }
}

@Composable
fun TextButtonSample() {
    TextButton(onClick = { /* Do something! */ }) { Text("Text Button") }
}

@Composable
fun ButtonWithIconSample() {
    Button(onClick = { /* Do something! */ }) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Like")
    }
}

@Preview
@Composable
fun ButtonSamplePreview() {
    ButtonSample()
}

@Preview
@Composable
fun OutlinedButtonSamplePreview() {
    OutlinedButtonSample()
}

@Preview
@Composable
fun TextButtonSamplePreview() {
    TextButtonSample()
}

@Preview
@Composable
fun ButtonWithIconSamplePreview() {
    ButtonWithIconSample()
}