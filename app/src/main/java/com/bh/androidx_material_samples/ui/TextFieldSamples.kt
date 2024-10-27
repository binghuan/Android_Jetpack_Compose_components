package com.bh.androidx_material_samples.ui

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SimpleTextFieldSample() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") },
        singleLine = true
    )
}

@Composable
fun SimpleOutlinedTextFieldSample() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") },
        singleLine = true
    )
}

@Composable
fun TextFieldWithIcons() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        placeholder = { Text("placeholder") },
        leadingIcon = {
            Icon(
                Icons.Filled.Favorite, contentDescription = null
            )
        },
        trailingIcon = {
            IconButton(onClick = { text = "" }) {
                Icon(Icons.Filled.Clear, contentDescription = "Clear text")
            }
        },
        singleLine = true
    )
}

@Composable
fun PasswordTextField() {
    var password by remember { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }
    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Enter password") },
        visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            IconButton(onClick = { passwordHidden = !passwordHidden }) {
                Icon(
                    imageVector = if (passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                    contentDescription = if (passwordHidden) "Show password" else "Hide password"
                )
            }
        },
        singleLine = true
    )
}

@Preview(showBackground = true)
@Composable
fun SimpleTextFieldSamplePreview() {
    SimpleTextFieldSample()
}

@Preview(showBackground = true)
@Composable
fun SimpleOutlinedTextFieldSamplePreview() {
    SimpleOutlinedTextFieldSample()
}

@Preview(showBackground = true)
@Composable
fun TextFieldWithIconsPreview() {
    TextFieldWithIcons()
}

@Preview(showBackground = true)
@Composable
fun PasswordTextFieldPreview() {
    PasswordTextField()
}
