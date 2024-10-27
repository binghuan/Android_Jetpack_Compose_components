package com.bh.androidx_material_samples.ui

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationDefaults
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BottomNavigationSample() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Songs", "Artists", "Playlists")

    BottomNavigation(windowInsets = BottomNavigationDefaults.windowInsets) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index })
        }
    }
}

@Composable
fun BottomNavigationWithOnlySelectedLabelsSample() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Songs", "Artists", "Playlists")

    BottomNavigation {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
                alwaysShowLabel = false
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationSamplePreview() {
    BottomNavigationSample()
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationWithOnlySelectedLabelsSamplePreview() {
    BottomNavigationWithOnlySelectedLabelsSample()
}