package com.bh.androidx_material_samples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bh.androidx_material_samples.ui.*
import com.bh.androidx_material_samples.ui.theme.AndroidxmaterialsamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidxmaterialsamplesTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationComponent(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(
    navController: NavHostController, modifier: Modifier = Modifier
) {
    val samples = listOf(
        "AlertDialogSample" to "alertDialog",
        "TopAppBarSample" to "appBar",
        "BackdropScaffoldSample" to "backdropScaffold",
        "BadgeSample" to "badge",
        "BottomNavigationSample" to "bottomNavigation",
        "BottomSheetScaffoldSample" to "bottomSheetScaffold",
        "ButtonSample" to "button",
        "CardSample" to "card",
        "ChipSample" to "chip",
        "ContentAlphaSample" to "contentAlpha",
        "DrawerSample" to "drawer",
        "ElevationSample" to "elevation",
        "ExposedDropdownMenuSample" to "exposedDropdownMenu",
        "FloatingActionButtonSample" to "fab",
        "IconButtonSample" to "iconButton",
        "ListSample" to "list",
        "MenuSample" to "menu",
        "ModalBottomSheetSample" to "modalBottomSheet",
        "NavigationRailSample" to "navigationRail",
        "ProgressIndicatorSample" to "progressIndicator",
        "PullRefreshSample" to "pullRefresh",
        "ScaffoldSample" to "scaffold",
        "SelectionControlsSample" to "selectionControls",
        "SliderSample" to "slider",
        "SurfaceSample" to "surface",
        "SwipeableSample" to "swipeable",
        "TabSample" to "tab",
        "TextFieldSample" to "textField",
        "TextSample" to "text",
        "ThemeSample" to "theme"
    )

    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(samples) { (label, route) ->
            Button(
                onClick = { navController.navigate(route) },
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(text = label)
            }
        }
    }
}

@Composable
fun NavigationComponent(
    navController: NavHostController, modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                navController = navController, modifier = modifier
            )
        }
        composable("alertDialog") { AlertDialogSample() }
        composable("appBar") { SimpleTopAppBar() }
        composable("backdropScaffold") { BackdropScaffoldSample() }
        composable("badge") { BottomNavigationItemWithBadge() }
        composable("bottomNavigation") { BottomNavigationSample() }
        composable("bottomSheetScaffold") { BottomSheetScaffoldSample() }
        composable("button") { ButtonSample() }
        composable("card") { CardSample() }
        composable("chip") { ChipSample() }
        composable("contentAlpha") { ContentAlphaSample() }
        composable("drawer") { ModalDrawerSample() }
        composable("elevation") { AbsoluteElevationSample() }
        composable("exposedDropdownMenu") { ExposedDropdownMenuSample() }
        composable("fab") { SimpleFab() }
        composable("iconButton") { IconButtonSample() }
        composable("list") { ClickableListItems() }
        composable("menu") { MenuSample() }
        composable("modalBottomSheet") { ModalBottomSheetSample() }
        composable("navigationRail") { NavigationRailSample() }
        composable("progressIndicator") { LinearProgressIndicatorSample() }
        composable("pullRefresh") { PullRefreshSample() }
        composable("scaffold") { SimpleScaffoldWithTopBar() }
        composable("selectionControls") { TriStateCheckboxSample() }
        composable("slider") { SliderSample() }
        composable("surface") { SurfaceSample() }
        composable("swipeable") { SwipeableSample() }
        composable("tab") { TextTabs() }
        composable("textField") { SimpleTextFieldSample() }
        composable("text") { TextWithLinks() }
        composable("theme") { MaterialThemeSample() }
    }
}
