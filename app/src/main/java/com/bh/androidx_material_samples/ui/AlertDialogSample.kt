package com.bh.androidx_material_samples.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AlertDialogSample() {
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(onDismissRequest = {
            openDialog.value = false
        }, title = { Text(text = "Title") }, text = {
            Text(
                "This area typically contains the supportive text which presents the details regarding the dialog's purpose."
            )
        }, confirmButton = {
            TextButton(onClick = { openDialog.value = false }) { Text("Confirm") }
        }, dismissButton = {
            TextButton(onClick = { openDialog.value = false }) { Text("Dismiss") }
        })
    }
}

@Composable
fun CustomAlertDialogSample() {
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(onDismissRequest = { openDialog.value = false },
            title = { Text(text = "Title") },
            text = {
                Text(
                    "This area typically contains the supportive text which presents the details regarding the dialog's purpose."
                )
            },
            confirmButton = {
                Row(
                    modifier = Modifier
                        .padding(all = 8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextButton(onClick = { openDialog.value = false }) {
                        Text("Dismiss")
                    }
                }
            },
            dismissButton = {
                TextButton(onClick = { openDialog.value = false }) {
                    Text("Cancel")
                }
            })
    }
}

@Preview(showBackground = true)
@Composable
fun AlertDialogSamplePreview() {
    AlertDialogSample()
}

@Preview(showBackground = true)
@Composable
fun CustomAlertDialogSamplePreview() {
    CustomAlertDialogSample()
}
