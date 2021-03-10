package com.pratamawijaya.composenews

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object Destinations {
    const val HOME_LIST = "home-list"
    const val DETAIL_NEWS = "detail-news"
}


@Composable
fun NavGraph(startDestination: String = Destinations.HOME_LIST) {
    val navController = rememberNavController()
    val actions = remember(navController) {
        MainActions(navController)
    }

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(Destinations.HOME_LIST) {

        }

        composable(Destinations.DETAIL_NEWS) {

        }
    }
}

class MainActions(navController: NavHostController) {

    //    val editNote: (Note) -> Unit = { note: Note ->
//        navController.currentBackStackEntry?.arguments?.putParcelable(
//            MainDestinations.NOTE_MODEL_KEY,
//            note
//        )
//        navController.navigate("${MainDestinations.EDIT_NOTE}/${note.id}")
//    }
    
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}