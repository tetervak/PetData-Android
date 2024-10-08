package ca.tetervak.petdata.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ca.tetervak.petdata.ui.petlist.PetListScreen

@Composable
fun AppRootScreen() {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "pet-list"
    ) {
        composable(route = "pet-list") {
            PetListScreen()
        }

    }
}