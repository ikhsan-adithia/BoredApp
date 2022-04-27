package com.bored.app.feature_bored.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bored.app.core.data.utils.Result
import com.bored.app.feature_bored.domain.repository.BoredRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.plus
import javax.inject.Inject

@HiltViewModel
class BoredViewModel @Inject constructor(
    private val repository: BoredRepository
): ViewModel() {

    private val _state = mutableStateOf(BoredState())
    val state: State<BoredState> get() = _state

    fun getRandomActivity() {
        repository.getRandomActivity()
            .onEach { result ->
                when (result) {
                    is Result.Success -> {
                        _state.value = state.value.copy(
                            isLoading = false,
                            randomActivity = result.data?.toRandomActivity()
                        )
                    }
                    is Result.Error -> {
                        _state.value = state.value.copy(isLoading = false)
                    }
                    is Result.Loading -> {
                        _state.value = state.value.copy(isLoading = true)
                    }
                }
            }
            .launchIn(viewModelScope.plus(Dispatchers.IO))
    }
}