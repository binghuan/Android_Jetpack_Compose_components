package com.bh.androidx_material_samples.ui

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BottomNavigationItemWithBadge() {
    BottomNavigation {
        BottomNavigationItem(icon = {
            BadgedBox(badge = {
                Badge {
                    val badgeNumber = "8"
                    Text(badgeNumber, modifier = Modifier.semantics {
                        contentDescription = "$badgeNumber new notifications"
                    })
                }
            }) {
                Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
            }
        }, selected = false, onClick = {})
    }
}


@Preview
@Composable
fun BottomNavigationItemWithBadgePreview() {
    BottomNavigationItemWithBadge()
}