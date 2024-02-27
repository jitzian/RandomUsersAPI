package com.org.test.randomusersapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.org.test.randomusersapp.ui.navigation.NavGraph

@Composable
fun MainScreenView() {
    val navController = rememberNavController()
    Box(modifier = Modifier.fillMaxSize()) { NavGraph(navController = navController) }
}