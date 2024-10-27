package com.bh.androidx_material_samples.ui

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.input.TextFieldValue

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExposedDropdownMenuSample() {
    val options = listOf("Option 1", "Option 2", "Option 3", "Option 4", "Option 5")
    var expanded by remember { mutableStateOf(false) }
    var textFieldValue by remember { mutableStateOf(TextFieldValue(options[0])) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it },
    ) {
        TextField(value = textFieldValue,
            onValueChange = { },
            readOnly = true,
            label = { Text("Label") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )
        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { selectionOption ->
                DropdownMenuItem(onClick = {
                    textFieldValue = TextFieldValue(selectionOption)
                    expanded = false
                }) {
                    Text(text = selectionOption)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EditableExposedDropdownMenuSample() {
    val options = listOf("Option 1", "Option 2", "Option 3", "Option 4", "Option 5")
    var expanded by remember { mutableStateOf(false) }
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it },
    ) {
        TextField(value = textFieldValue,
            onValueChange = { textFieldValue = it },
            label = { Text("Label") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )
        // filter options based on text field value
        val filteringOptions =
            options.filter { it.contains(textFieldValue.text, ignoreCase = true) }
        if (filteringOptions.isNotEmpty()) {
            ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                filteringOptions.forEach { selectionOption ->
                    DropdownMenuItem(onClick = {
                        textFieldValue = TextFieldValue(selectionOption)
                        expanded = false
                    }) {
                        Text(text = selectionOption)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExposedDropdownMenuSamplePreview() {
    ExposedDropdownMenuSample()
}

@Preview(showBackground = true)
@Composable
fun EditableExposedDropdownMenuSamplePreview() {
    EditableExposedDropdownMenuSample()
}
