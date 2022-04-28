package com.bored.app.core.presentation.utils

sealed class UiEvent {
    data class ShowSnackbar(val uiText: UiText): UiEvent()
}
