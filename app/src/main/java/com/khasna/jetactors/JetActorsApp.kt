package com.khasna.jetactors

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.khasna.jetactors.ui.screen.about.AboutScreen
import com.khasna.jetactors.ui.screen.detail.DetailScreen
import com.khasna.jetactors.ui.screen.home.HomeScreen
import com.khasna.jetactors.utils.Route

@Composable
fun JetActorsApp(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
) {
    NavHost(navController = navHostController,
        startDestination = Route.Home.path,
        modifier = modifier,
    ){
        composable(Route.Home.path) {
            HomeScreen(
                navigateToAbout = {
                navHostController.navigate(Route.About.path)
            },
                navigateToDetail = { actorsId ->
                    navHostController.navigate(Route.Detail.createRoute(actorsId))
                }
            )
        }
        composable(Route.About.path){
            AboutScreen(
                navigateUp = { navHostController.navigateUp() }
            )
        }
        composable(
            route = Route.Detail.path,
            arguments = listOf(navArgument("actorsId") { type = NavType.StringType}),
        ){
            val id = it.arguments?.getString("actorsId") ?: "00"
            DetailScreen(
                idActors = id,
                navigateUp = { navHostController.navigateUp() }
            )
        }
    }
}