package com.anirudh.mvvmcleancodeapp.feature.domain.repository

import com.anirudh.mvvmcleancodeapp.core.util.Resource
import com.anirudh.mvvmcleancodeapp.feature.data.remote.dto.DataDTO
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getData(): Flow<Resource<DataDTO>>
}