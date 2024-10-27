package com.bh.androidx_material_samples.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.ContentAlpha
import androidx.wear.compose.material.LocalContentAlpha

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTopAppBar() {
    TopAppBar(
        title = { Text("Simple TopAppBar") },
        navigationIcon = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Menu, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Favorite, contentDescription = "Localized description")
            }
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Favorite, contentDescription = "Localized description")
            }
        }
    )
}

@Composable
fun SimpleBottomAppBar() {
    BottomAppBar {
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Menu, contentDescription = "Localized description")
            }
        }
        Spacer(Modifier.weight(1f, true))
        IconButton(onClick = { /* doSomething() */ }) {
            Icon(Icons.Filled.Favorite, contentDescription = "Localized description")
        }
        IconButton(onClick = { /* doSomething() */ }) {
            Icon(Icons.Filled.Favorite, contentDescription = "Localized description")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleTopAppBarPreview() {
    SimpleTopAppBar()
}

@Preview(showBackground = true)
@Composable
fun SimpleBottomAppBarPreview() {
    SimpleBottomAppBar()
}