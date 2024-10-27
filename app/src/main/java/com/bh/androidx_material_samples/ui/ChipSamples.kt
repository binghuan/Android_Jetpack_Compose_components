package com.bh.androidx_material_samples.ui

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FilterChip
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChipSample() {
    Chip(onClick = { /* Do something! */ }) { Text("Action Chip") }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OutlinedChipWithIconSample() {
    Chip(onClick = { /* Do something! */ },
        border = ChipDefaults.outlinedBorder,
        colors = ChipDefaults.outlinedChipColors(),
        leadingIcon = {
            Icon(
                Icons.Filled.Settings, contentDescription = "Localized description"
            )
        }) {
        Text("Change settings")
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FilterChipSample() {
    val state = remember { mutableStateOf(false) }
    FilterChip(selected = state.value, onClick = { state.value = !state.value }, selectedIcon = {
        Icon(
            imageVector = Icons.Filled.Done,
            contentDescription = "Localized Description",
            modifier = Modifier.requiredSize(ChipDefaults.SelectedIconSize)
        )
    }) {
        Text("Filter chip")
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OutlinedFilterChipSample() {
    val state = remember { mutableStateOf(false) }
    FilterChip(selected = state.value,
        onClick = { state.value = !state.value },
        border = ChipDefaults.outlinedBorder,
        colors = ChipDefaults.outlinedFilterChipColors(),
        selectedIcon = {
            Icon(
                imageVector = Icons.Filled.Done,
                contentDescription = "Localized Description",
                modifier = Modifier.requiredSize(ChipDefaults.SelectedIconSize)
            )
        }) {
        Text("Filter chip")
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FilterChipWithLeadingIconSample() {
    val state = remember { mutableStateOf(false) }
    FilterChip(selected = state.value, onClick = { state.value = !state.value }, leadingIcon = {
        Icon(
            imageVector = Icons.Filled.Home,
            contentDescription = "Localized description",
            modifier = Modifier.requiredSize(ChipDefaults.LeadingIconSize)
        )
    }, selectedIcon = {
        Icon(
            imageVector = Icons.Filled.Done,
            contentDescription = "Localized Description",
            modifier = Modifier.requiredSize(ChipDefaults.SelectedIconSize)
        )
    }) {
        Text("Filter chip")
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChipGroupSingleLineSample() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            repeat(9) { index ->
                Chip(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    onClick = { /* do something*/ }) {
                    Text("Chip $index")
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class, ExperimentalLayoutApi::class)
@Composable
fun ChipGroupReflowSample() {
    Column {
        FlowRow(
            Modifier
                .fillMaxWidth(1f)
                .wrapContentHeight(align = Alignment.Top),
            horizontalArrangement = Arrangement.Start,
        ) {
            repeat(10) { index ->
                Chip(modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .align(alignment = Alignment.CenterVertically),
                    onClick = { /* do something*/ }) {
                    Text("Chip $index")
                }
            }
        }
    }
}

@Preview
@Composable
fun ChipSamplePreview() {
    ChipSample()
}

@Preview
@Composable
fun OutlinedChipWithIconSamplePreview() {
    OutlinedChipWithIconSample()
}

@Preview
@Composable
fun FilterChipSamplePreview() {
    FilterChipSample()
}

@Preview
@Composable
fun OutlinedFilterChipSamplePreview() {
    OutlinedFilterChipSample()
}

@Preview
@Composable
fun FilterChipWithLeadingIconSamplePreview() {
    FilterChipWithLeadingIconSample()
}

@Preview
@Composable
fun ChipGroupSingleLineSamplePreview() {
    ChipGroupSingleLineSample()
}

@Preview
@Composable
fun ChipGroupReflowSamplePreview() {
    ChipGroupReflowSample()
}