package com.anirudh.mvvmcleancodeapp.feature.domain.use_case

import com.anirudh.mvvmcleancodeapp.core.util.Resource
import com.anirudh.mvvmcleancodeapp.feature.data.remote.dto.DataDTO
import com.anirudh.mvvmcleancodeapp.feature.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetDataUseCase(private val repository: Repository) {
    operator fun invoke(): Flow<Resource<DataDTO>> = repository.getData()
}