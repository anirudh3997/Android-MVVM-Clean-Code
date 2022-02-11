package com.anirudh.mvvmcleancodeapp.feature.presentation.screens.featureScreen

data class FeatureState(
    var isLoading: Boolean = true,
    var isFailed: Boolean = false,
    var errorMessage: String = ""
)
