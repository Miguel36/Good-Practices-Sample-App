package com.skyfallen.goodpracticessampleapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.skyfallen.goodpracticessampleapp.ui.characters.CharactersScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Characters) {
        composable<Characters> {
            CharactersScreen()
        }
    }
}