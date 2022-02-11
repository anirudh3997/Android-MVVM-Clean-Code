package com.anirudh.mvvmcleancodeapp.feature.data.repository

import com.anirudh.mvvmcleancodeapp.core.util.Resource
import com.anirudh.mvvmcleancodeapp.feature.data.remote.API
import com.anirudh.mvvmcleancodeapp.feature.data.remote.dto.DataDTO
import com.anirudh.mvvmcleancodeapp.feature.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class RepositoryImpl(private val api: API): Repository {
    override fun getData(): Flow<Resource<DataDTO>> = flow {
        emit(Resource.Loading())
        try {
            val data = api.getData()
            emit(Resource.Success(data))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Oops, something went wrong!"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Couldn't reach server, check your internet connection."))
        }
    }
}