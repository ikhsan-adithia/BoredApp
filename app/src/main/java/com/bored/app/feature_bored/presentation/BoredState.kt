package com.bored.app.feature_bored.presentation

import com.bored.app.feature_bored.domain.model.RandomActivity

data class BoredState(
    val isLoading: Boolean = false,
    val randomActivity: RandomActivity? = null
)
