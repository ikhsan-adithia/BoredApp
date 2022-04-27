package com.bored.app.feature_bored.data.repository

import com.bored.app.core.data.utils.Result
import com.bored.app.core.data.utils.unwrap
import com.bored.app.core.domain.utils.JsonParser
import com.bored.app.feature_bored.data.dto.RandomActivityDto
import com.bored.app.feature_bored.data.remote.BoredApi
import com.bored.app.feature_bored.domain.repository.BoredRepository
import kotlinx.coroutines.flow.Flow

class BoredRepositoryImpl(
    private val service: BoredApi,
    private val jsonParser: JsonParser
): BoredRepository {

    override fun getRandomActivity(): Flow<Result<RandomActivityDto>> =
        unwrap(jsonParser) { service.getRandomActivity() }
}