package com.anirudh.mvvmcleancodeapp.feature.presentation.screens.featureScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.anirudh.mvvmcleancodeapp.core.util.Resource
import com.anirudh.mvvmcleancodeapp.feature.domain.use_case.GetDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FeatureViewModel @Inject constructor(
    private val getDataUseCase: GetDataUseCase,
) : ViewModel(){
    private val _state = mutableStateOf(FeatureState())
    val state: State<FeatureState> = _state
    init {
        getDataUseCase().onEach { response ->
            when(response){
                is Resource.Error -> {
                    _state.value = state.value.copy(
                        isLoading = false,
                        isFailed = true,
                        errorMessage = response.message.toString()
                    )
                }
                is Resource.Loading -> _state.value = state.value.copy(isLoading = true)
                is Resource.Success -> {
                    response.data?.let {
                        _state.value = state.value.copy(
                            isLoading = false,
                        )
                    }
                }
            }

        }
    }
}
