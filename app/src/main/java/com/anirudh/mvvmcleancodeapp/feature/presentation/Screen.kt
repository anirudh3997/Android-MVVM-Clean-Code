package com.anirudh.mvvmcleancodeapp.feature.presentation

sealed class Screen(val route: String) {
    object FeatureScreen : Screen("featureScreen")
}