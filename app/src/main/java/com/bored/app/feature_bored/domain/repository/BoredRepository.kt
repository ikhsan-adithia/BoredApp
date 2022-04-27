package com.bored.app.feature_bored.domain.repository

import com.bored.app.core.data.utils.Result
import com.bored.app.feature_bored.data.dto.RandomActivityDto
import kotlinx.coroutines.flow.Flow

interface BoredRepository {

    fun getRandomActivity(): Flow<Result<RandomActivityDto>>
}