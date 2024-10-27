package com.developerx.base.extensions

import android.content.SharedPreferences


fun SharedPreferences.getCachedString(key: String, defaultValue: String): String {
    return getString(key, defaultValue) ?: ""
}

fun SharedPreferences.cacheString(key: String, value: String) {
    edit().putString(key, value).apply()
}
