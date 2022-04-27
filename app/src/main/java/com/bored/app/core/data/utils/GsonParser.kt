package com.bored.app.core.data.utils

import com.bored.app.core.domain.utils.JsonParser
import com.google.gson.Gson
import com.google.gson.JsonIOException
import com.google.gson.JsonSyntaxException
import java.lang.reflect.Type

class GsonParser(private val gson: Gson): JsonParser {

    override fun <T> fromJson(json: String, type: Type): T? {
        return try {
            gson.fromJson<T>(json, type)
        } catch (e: JsonSyntaxException) {
            null
        } catch (e: JsonIOException) {
            null
        }
    }

    override fun <T> toJson(obj: T, type: Type): String? {
        return try {
            gson.toJson(obj, type)
        } catch (e: JsonSyntaxException) {
            null
        } catch (e: JsonIOException) {
            null
        }
    }
}