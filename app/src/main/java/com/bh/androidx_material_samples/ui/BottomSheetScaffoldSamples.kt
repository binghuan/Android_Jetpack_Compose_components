package com.bh.androidx_material_samples.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.Button
import androidx.compose.material.DrawerValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

private val colors = listOf(
    Color(0xFFffd7d7.toInt()),
    Color(0xFFffe9d6.toInt()),
    Color(0xFFfffbd0.toInt()),
    Color(0xFFe3ffd9.toInt()),
    Color(0xFFd0fff8.toInt())
)

@Composable
fun BottomSheetScaffoldSample() {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()
    BottomSheetScaffold(sheetContent = {
        Box(
            Modifier
                .fillMaxWidth()
                .height(128.dp), contentAlignment = Alignment.Center
        ) {
            Text("Swipe up to expand sheet")
        }
        Column(
            Modifier
                .fillMaxWidth()
                .padding(64.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Sheet content")
            Spacer(Modifier.height(20.dp))
            Button(onClick = { scope.launch { scaffoldState.bottomSheetState.collapse() } }) {
                Text("Click to collapse sheet")
            }
        }
    },
        scaffoldState = scaffoldState,
        topBar = { TopAppBar { Text("Bottom sheet scaffold") } },
        floatingActionButton = {
            var clickCount by remember { mutableIntStateOf(0) }
            FloatingActionButton(onClick = {
                // show snackbar as a suspend function
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("Snackbar #${++clickCount}")
                }
            }) {
                Icon(Icons.Default.Favorite, contentDescription = "Localized description")
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        sheetPeekHeight = 128.dp
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            items(100) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(colors[it % colors.size])
                )
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun BottomSheetScaffoldWithDrawerSample() {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    ModalDrawer(drawerState = drawerState, drawerContent = {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Drawer content")
            Spacer(Modifier.height(20.dp))
            Button(onClick = { scope.launch { drawerState.close() } }) {
                Text("Click to close drawer")
            }
        }
    }) {
        BottomSheetScaffold(sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(128.dp), contentAlignment = Alignment.Center
            ) {
                Text("Swipe up to expand sheet")
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(64.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Sheet content")
                Spacer(Modifier.height(20.dp))
                Button(onClick = { scope.launch { scaffoldState.bottomSheetState.collapse() } }) {
                    Text("Click to collapse sheet")
                }
            }
        }, scaffoldState = scaffoldState, topBar = {
            TopAppBar(title = { Text("Bottom sheet scaffold") }, navigationIcon = {
                IconButton(onClick = { scope.launch { drawerState.open() } }) {
                    Icon(Icons.Default.Menu, contentDescription = "Localized description")
                }
            })
        }, floatingActionButton = {
            var clickCount by remember { mutableStateOf(0) }
            FloatingActionButton(onClick = {
                // show snackbar as a suspend function
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        "Snackbar #${++clickCount}"
                    )
                }
            }) {
                Icon(Icons.Default.Favorite, contentDescription = "Localized description")
            }
        }, floatingActionButtonPosition = FabPosition.End, sheetPeekHeight = 128.dp
        ) { innerPadding ->
            LazyColumn(contentPadding = innerPadding) {
                items(100) {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .background(colors[it % colors.size])
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomSheetScaffoldSamplePreview() {
    BottomSheetScaffoldSample()
}

@Preview(showBackground = true)
@Composable
fun BottomSheetScaffoldWithDrawerSamplePreview() {
    BottomSheetScaffoldWithDrawerSample()
}