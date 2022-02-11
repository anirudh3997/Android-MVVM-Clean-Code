package com.anirudh.mvvmcleancodeapp.feature.di

import com.anirudh.mvvmcleancodeapp.feature.data.remote.API
import com.anirudh.mvvmcleancodeapp.feature.data.repository.RepositoryImpl
import com.anirudh.mvvmcleancodeapp.feature.domain.repository.Repository
import com.anirudh.mvvmcleancodeapp.feature.domain.use_case.GetDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGetDataUseCase(repository: Repository): GetDataUseCase {
        return GetDataUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideMoviesRepository(api: API): Repository {
        return RepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideApi(): API {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
            .baseUrl(API.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API::class.java)
    }
}