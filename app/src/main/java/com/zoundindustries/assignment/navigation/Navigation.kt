package com.zoundindustries.assignment.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zoundindustries.main.presentation.MainScreen
import com.zoundindustries.main.presentation.MainViewModel
import com.zoundindustries.navigation.destinations.MainDestination


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MainDestination.route) {
        composable(route = MainDestination.route) {
            val viewModel: MainViewModel = hiltViewModel()
            MainScreen(viewModel, viewModel::onListRefresh, viewModel::onCurrencyChanged)
        }
    }
}