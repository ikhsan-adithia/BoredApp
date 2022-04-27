package com.bored.app.core.presentation.utils

import android.content.Context
import androidx.annotation.StringRes
import com.bored.app.R

sealed class UiText {
    data class StringResource(@StringRes val resId: Int, val type: UiTextType = UiTextType.NORMAL): UiText()
    data class DynamicString(val value: String, val type: UiTextType = UiTextType.NORMAL): UiText()

    companion object {
        fun unknownError() = StringResource(R.string.general_message_unknown_error)
    }
}

fun UiText.asString(context: Context): String {
    return when(this) {
        is UiText.DynamicString -> this.value
        is UiText.StringResource -> context.getString(this.resId)
    }
}