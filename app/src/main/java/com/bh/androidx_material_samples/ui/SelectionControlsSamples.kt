package com.bh.androidx_material_samples.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.InputMode.Companion.Keyboard
import androidx.compose.ui.platform.LocalInputModeManager
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TriStateCheckboxSample() {
    Column {
        // define dependent checkboxes states
        val (state, onStateChange) = remember { mutableStateOf(true) }
        val (state2, onStateChange2) = remember { mutableStateOf(true) }

        // TriStateCheckbox state reflects state of dependent checkboxes
        val parentState = remember(state, state2) {
            if (state && state2) ToggleableState.On
            else if (!state && !state2) ToggleableState.Off else ToggleableState.Indeterminate
        }
        // click on TriStateCheckbox can set state for dependent checkboxes
        val onParentClick = {
            val s = parentState != ToggleableState.On
            onStateChange(s)
            onStateChange2(s)
        }

        TriStateCheckbox(
            state = parentState,
            onClick = onParentClick,
            colors = CheckboxDefaults.colors(checkedColor = MaterialTheme.colors.primary)
        )
        Spacer(Modifier.size(25.dp))
        Column(Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)) {
            Checkbox(state, onStateChange)
            Spacer(Modifier.size(25.dp))
            Checkbox(state2, onStateChange2)
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FocusedCheckboxSample() {
    Text("The gray circle around this checkbox means it's non-touch focused.  Press Tab to move it")

    val focusRequester = FocusRequester()
    Box(Modifier.wrapContentSize(Alignment.TopStart)) {
        Checkbox(modifier = Modifier
            .wrapContentSize(Alignment.TopStart)
            .focusRequester(focusRequester),
            checked = true,
            onCheckedChange = {})
    }

    val localInputModeManager = LocalInputModeManager.current
    LaunchedEffect(Unit) {
        if (localInputModeManager.requestInputMode(Keyboard)) {
            focusRequester.requestFocus()
        }
    }
}


@Composable
fun CheckboxSample() {
    val checkedState = remember { mutableStateOf(true) }
    Checkbox(checked = checkedState.value,
        onCheckedChange = { checkedState.value = it })
}


@Composable
fun SwitchSample() {
    val checkedState = remember { mutableStateOf(true) }
    Switch(checked = checkedState.value,
        onCheckedChange = { checkedState.value = it })

    var pineappleOnPizza by remember { mutableStateOf(true) }

    Row(
        Modifier
            .padding(16.dp)
            .toggleable(
                role = Role.Switch,
                value = pineappleOnPizza,
                onValueChange = { pineappleOnPizza = it },
            )
    ) {
        Switch(checked = pineappleOnPizza, onCheckedChange = null)
        Spacer(Modifier.width(8.dp))
        Text("Pineapple on pizza?")
    }
}


@Composable
fun RadioButtonSample() {
    // We have two radio buttons and only one can be selected
    var state by remember { mutableStateOf(true) }
    // Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior
    Row(Modifier.selectableGroup()) {
        RadioButton(selected = state, onClick = { state = true })
        RadioButton(selected = !state, onClick = { state = false })
    }
}


@Composable
fun RadioGroupSample() {
    val radioOptions = listOf("Calls", "Missed", "Friends")
    val (selectedOption, onOptionSelected) = remember {
        mutableStateOf(
            radioOptions[0]
        )
    }
    // Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior
    Column(Modifier.selectableGroup()) {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = null // null recommended for accessibility with screenreaders
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.body1.merge(),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun TriStateCheckboxSamplePreview() {
    TriStateCheckboxSample()
}

@Preview
@Composable
fun FocusedCheckboxSamplePreview() {
    FocusedCheckboxSample()
}

@Preview
@Composable
fun CheckboxSamplePreview() {
    CheckboxSample()
}

@Preview
@Composable
fun SwitchSamplePreview() {
    SwitchSample()
}

@Preview
@Composable
fun RadioButtonSamplePreview() {
    RadioButtonSample()
}

@Preview
@Composable
fun RadioGroupSamplePreview() {
    RadioGroupSample()
}
