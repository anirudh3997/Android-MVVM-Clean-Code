package com.anirudh.mvvmcleancodeapp.feature.data.remote

import com.anirudh.mvvmcleancodeapp.feature.data.remote.dto.DataDTO
import retrofit2.http.GET

interface API {

    @GET("/")
    suspend fun getData(): DataDTO

    companion object {
        const val BASE_URL = "https://anirudh.mangalvedhe.in"
    }
}