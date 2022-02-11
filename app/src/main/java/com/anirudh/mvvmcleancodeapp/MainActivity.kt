package com.anirudh.mvvmcleancodeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.anirudh.mvvmcleancodeapp.feature.presentation.Screen
import com.anirudh.mvvmcleancodeapp.feature.presentation.screens.featureScreen.FeatureScreen
import com.anirudh.mvvmcleancodeapp.ui.theme.MVVMCleanCodeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMCleanCodeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.FeatureScreen.route
                    ) {
                        composable(route = Screen.FeatureScreen.route) {
                            FeatureScreen(navController = navController)
                        }
                        composable(route = Screen.FeatureScreen.route +
                                "?data={dataId}",
                            arguments = listOf(
                                navArgument(name = "dataId") {
                                    type = NavType.StringType
                                }
                            )
                        ) {
                            FeatureScreen(
                                navController = navController,
                            )
                        }
                    }
                }
            }
        }
    }
}