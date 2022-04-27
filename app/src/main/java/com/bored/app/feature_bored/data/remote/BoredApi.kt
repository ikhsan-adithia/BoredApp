package com.bored.app.feature_bored.data.remote

import com.bored.app.feature_bored.data.dto.RandomActivityDto
import retrofit2.http.GET

interface BoredApi {

    @GET("/api/activity")
    suspend fun getRandomActivity(): RandomActivityDto

    companion object {
        const val BASE_URL = "https://www.boredapi.com"
    }
}