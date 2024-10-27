package com.bh.androidx_material_samples.ui

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FabPosition
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldDefaults
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SnackbarResult
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.math.roundToInt

private val colors = listOf(
    Color(0xFFffd7d7.toInt()),
    Color(0xFFffe9d6.toInt()),
    Color(0xFFfffbd0.toInt()),
    Color(0xFFe3ffd9.toInt()),
    Color(0xFFd0fff8.toInt())
)


@Composable
fun SimpleScaffoldWithTopBar() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(scaffoldState = scaffoldState,
        drawerContent = { Text("Drawer content") },
        topBar = {
            TopAppBar(title = { Text("Simple Scaffold Screen") },
                navigationIcon = {
                    IconButton(onClick = { scope.launch { scaffoldState.drawerState.open() } }) {
                        Icon(
                            Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                })
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            ExtendedFloatingActionButton(text = { Text("Inc") },
                onClick = { /* fab click handler */ })
        },
        contentWindowInsets = ScaffoldDefaults.contentWindowInsets,
        content = { innerPadding ->
            LazyColumn(contentPadding = innerPadding) {
                items(count = 100) {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .background(colors[it % colors.size])
                    )
                }
            }
        })
}


@Composable
fun ScaffoldWithBottomBarAndCutout() {
    val scaffoldState = rememberScaffoldState()

    // Consider negative values to mean 'cut corner' and positive values to mean 'round corner'
    val sharpEdgePercent = -50f
    val roundEdgePercent = 45f
    // Start with sharp edges
    val animatedProgress = remember { Animatable(sharpEdgePercent) }
    // Create a coroutineScope for the animation
    val coroutineScope = rememberCoroutineScope()
    // animation value to animate shape
    val progress = animatedProgress.value.roundToInt()

    // When progress is 0, there is no modification to the edges so we are just drawing a rectangle.
    // This allows for a smooth transition between cut corners and round corners.
    val fabShape = if (progress < 0) {
        CutCornerShape(abs(progress))
    } else if (progress == roundEdgePercent.toInt()) {
        CircleShape
    } else {
        RoundedCornerShape(progress)
    }
    // lambda to call to trigger shape animation
    val changeShape: () -> Unit = {
        val target = animatedProgress.targetValue
        val nextTarget =
            if (target == roundEdgePercent) sharpEdgePercent else roundEdgePercent
        coroutineScope.launch {
            animatedProgress.animateTo(
                targetValue = nextTarget,
                animationSpec = TweenSpec(durationMillis = 600)
            )
        }
    }

    Scaffold(scaffoldState = scaffoldState,
        drawerContent = { Text("Drawer content") },
        topBar = { TopAppBar(title = { Text("Scaffold with bottom cutout") }) },
        bottomBar = {
            BottomAppBar(cutoutShape = fabShape) {
                IconButton(onClick = { coroutineScope.launch { scaffoldState.drawerState.open() } }) {
                    Icon(
                        Icons.Filled.Menu,
                        contentDescription = "Localized description"
                    )
                }
            }
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Change shape") },
                onClick = changeShape,
                shape = fabShape
            )
        },
        contentWindowInsets = ScaffoldDefaults.contentWindowInsets,
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        content = { innerPadding ->
            LazyColumn(contentPadding = innerPadding) {
                items(count = 100) {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .background(colors[it % colors.size])
                    )
                }
            }
        })
}


@Composable
fun ScaffoldWithSimpleSnackbar() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(scaffoldState = scaffoldState,
        floatingActionButton = {
            var clickCount by remember { mutableIntStateOf(0) }
            ExtendedFloatingActionButton(text = { Text("Show snackbar") },
                onClick = {
                    // show snackbar as a suspend function
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Snackbar # ${++clickCount}")
                    }
                })
        },
        contentWindowInsets = ScaffoldDefaults.contentWindowInsets,
        content = { innerPadding ->
            Text(
                text = "Body content",
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .wrapContentSize()
            )
        })
}


@Composable
fun ScaffoldWithCustomSnackbar() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(scaffoldState = scaffoldState,
        snackbarHost = {
            // reuse default SnackbarHost to have default animation and timing handling
            SnackbarHost(it) { data ->
                // custom snackbar with the custom border
                Snackbar(
                    modifier = Modifier.border(
                        2.dp, MaterialTheme.colors.secondary
                    ), snackbarData = data
                )
            }
        },
        floatingActionButton = {
            var clickCount by remember { mutableIntStateOf(0) }
            ExtendedFloatingActionButton(text = { Text("Show snackbar") },
                onClick = {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Snackbar # ${++clickCount}")
                    }
                })
        },
        contentWindowInsets = ScaffoldDefaults.contentWindowInsets,
        content = { innerPadding ->
            Text(
                text = "Custom Snackbar Demo",
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .wrapContentSize()
            )
        })
}


@Composable
fun ScaffoldWithCoroutinesSnackbar() {
    // decouple snackbar host state from scaffold state for demo purposes
    // this state, channel and flow is for demo purposes to demonstrate business logic layer
    val snackbarHostState = remember { SnackbarHostState() }
    // we allow only one snackbar to be in the queue here, hence conflated
    val channel = remember { Channel<Int>(Channel.Factory.CONFLATED) }
    LaunchedEffect(channel) {
        channel.receiveAsFlow().collect { index ->
            val result = snackbarHostState.showSnackbar(
                message = "Snackbar # $index", actionLabel = "Action on $index"
            )
            when (result) {
                SnackbarResult.ActionPerformed -> {/* action has been performed */
                }

                SnackbarResult.Dismissed -> {/* dismissed, no action needed */
                }
            }
        }
    }
    Scaffold(
        // attach snackbar host state to the scaffold
        scaffoldState = rememberScaffoldState(snackbarHostState = snackbarHostState),
        floatingActionButton = {
            var clickCount by remember { mutableIntStateOf(0) }
            ExtendedFloatingActionButton(text = { Text("Show snackbar") },
                onClick = {
                    // offset snackbar data to the business logic
                    channel.trySend(++clickCount)
                })
        },
        contentWindowInsets = ScaffoldDefaults.contentWindowInsets,
        content = { innerPadding ->
            Text(
                "Snackbar demo",
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .wrapContentSize()
            )
        })
}

@Preview
@Composable
fun SimpleScaffoldWithTopBarPreview() {
    SimpleScaffoldWithTopBar()
}

@Preview
@Composable
fun ScaffoldWithBottomBarAndCutoutPreview() {
    ScaffoldWithBottomBarAndCutout()
}

@Preview
@Composable
fun ScaffoldWithSimpleSnackbarPreview() {
    ScaffoldWithSimpleSnackbar()
}

@Preview
@Composable
fun ScaffoldWithCustomSnackbarPreview() {
    ScaffoldWithCustomSnackbar()
}

@Preview
@Composable
fun ScaffoldWithCoroutinesSnackbarPreview() {
    ScaffoldWithCoroutinesSnackbar()
}
