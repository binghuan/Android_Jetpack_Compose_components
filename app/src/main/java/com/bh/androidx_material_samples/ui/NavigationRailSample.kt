package com.bh.androidx_material_samples.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.Icon
import androidx.compose.material.NavigationRail
import androidx.compose.material.NavigationRailDefaults
import androidx.compose.material.NavigationRailItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NavigationRailSample() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Search", "Settings")
    val icons =
        listOf(Icons.Filled.Home, Icons.Filled.Search, Icons.Filled.Settings)
    NavigationRail(windowInsets = NavigationRailDefaults.windowInsets) {
        items.forEachIndexed { index, item ->
            NavigationRailItem(icon = {
                Icon(
                    icons[index],
                    contentDescription = item
                )
            },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index })
        }
    }
}

@Composable
fun NavigationRailWithOnlySelectedLabelsSample() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Search", "Settings")
    val icons =
        listOf(Icons.Filled.Home, Icons.Filled.Search, Icons.Filled.Settings)
    NavigationRail {
        items.forEachIndexed { index, item ->
            NavigationRailItem(icon = {
                Icon(
                    icons[index],
                    contentDescription = item
                )
            },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
                alwaysShowLabel = false
            )
        }
    }
}

@Composable
fun CompactNavigationRailSample() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Search", "Settings")
    val icons =
        listOf(Icons.Filled.Home, Icons.Filled.Search, Icons.Filled.Settings)
    NavigationRail {
        items.forEachIndexed { index, item ->
            NavigationRailItem(icon = {
                Icon(
                    icons[index],
                    contentDescription = item
                )
            },
                selected = selectedItem == index,
                onClick = { selectedItem = index })
        }
    }
}

@Composable
fun NavigationRailBottomAlignSample() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Search", "Settings")
    val icons =
        listOf(Icons.Filled.Home, Icons.Filled.Search, Icons.Filled.Settings)

    NavigationRail {
        // A Spacer that pushes the NavigationRail items to the bottom of the NavigationRail.
        Spacer(Modifier.weight(1f))
        items.forEachIndexed { index, item ->
            NavigationRailItem(icon = {
                Icon(
                    icons[index],
                    contentDescription = item
                )
            },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
                alwaysShowLabel = false
            )
        }
    }
}

@Preview
@Composable
fun NavigationRailSamplePreview() {
    NavigationRailSample()
}

@Preview
@Composable
fun NavigationRailWithOnlySelectedLabelsSamplePreview() {
    NavigationRailWithOnlySelectedLabelsSample()
}

@Preview
@Composable
fun CompactNavigationRailSamplePreview() {
    CompactNavigationRailSample()
}

@Preview
@Composable
fun NavigationRailBottomAlignSamplePreview() {
    NavigationRailBottomAlignSample()
}