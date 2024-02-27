package com.org.test.randomusersapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.org.test.randomusersapp.ui.screens.details.ui.DetailsScreenState
import com.org.test.randomusersapp.ui.screens.main.ui.MainState

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.MainNavScreen.route
    ) {
        addMainScreen(navController, this)
        addDetailScreen(navController, this)
    }
}

private fun addMainScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = Screens.MainNavScreen.route) {
        MainState(
            navigateToDetails = { userId ->
                navController.navigate(Screens.DetailsNavScreen.route + "/$userId")
            }
        )
    }
}

private fun addDetailScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = Screens.DetailsNavScreen.withArgsFormat(
            Screens.DetailsNavScreen.id
        ),
        arguments = listOf(
            navArgument(Screens.DetailsNavScreen.id) {
                type = NavType.StringType
            }
        )
    ) { navBackStackEntry ->
        val args = navBackStackEntry.arguments
        DetailsScreenState(
            onBackClick = {
                navController.popBackStack()
            },
            id = args?.getString(Screens.DetailsNavScreen.id) ?: "0"
        )
    }
}