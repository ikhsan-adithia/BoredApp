package com.bored.app.feature_bored.data.dto

import com.bored.app.feature_bored.domain.model.RandomActivity
import com.google.gson.annotations.SerializedName

data class RandomActivityDto(

	@field:SerializedName("activity")
	val activity: String,

	@field:SerializedName("accessibility")
	val accessibility: Double,

	@field:SerializedName("price")
	val price: Double,

	@field:SerializedName("link")
	val link: String,

	@field:SerializedName("type")
	val type: String,

	@field:SerializedName("key")
	val key: String,

	@field:SerializedName("participants")
	val participants: Int
) {
	fun toRandomActivity() = RandomActivity(
		activity = activity,
		type = type,
		participants = participants
	)
}
