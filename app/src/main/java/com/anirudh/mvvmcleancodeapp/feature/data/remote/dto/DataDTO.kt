package com.anirudh.mvvmcleancodeapp.feature.data.remote.dto

import com.google.gson.annotations.SerializedName

data class DataDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)