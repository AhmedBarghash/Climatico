package com.developerx.base.datamanager

import android.content.SharedPreferences
import com.developerx.base.extensions.cacheString
import com.developerx.base.extensions.getCachedString
import javax.inject.Inject

class DataManager
@Inject constructor(
    private var sharedPreferences: SharedPreferences
) {
    companion object {
        const val PREF_NAME = "Insta_Plus_Pref"

        // OS
        const val PREF_OS_NAME = "OS_NAME_KEY"

        // Run Mode
        const val PREF_RUN_MODE = "RUN MODE_KEY"

        // PrivateSecret
        const val PREF_PRIVATE_SECRET = "PRIVATE_SECRET_KEY"

        // Url
        const val PREF_ENV_URL = "ENV_URL_KEY"

        // SignatureKey
        const val PREF_SIGNATURE_KEY = "SIGNATURE_KEY"

        const val IMAGE_PATH_KEY = "SELECTED_IMAGE_PATH_KEY"
    }


    var os: String
        get() = sharedPreferences.getCachedString(PREF_OS_NAME, "android")
        set(value) = sharedPreferences.cacheString(PREF_OS_NAME, value)
    var runMode: String
        get() = sharedPreferences.getCachedString(PREF_RUN_MODE, "")
        set(value) = sharedPreferences.cacheString(PREF_RUN_MODE, value)

    var privateSecret: String
        get() = sharedPreferences.getCachedString(PREF_PRIVATE_SECRET, "")
        set(value) = sharedPreferences.cacheString(PREF_PRIVATE_SECRET, value)

    var baseApiUrl: String
        get() = sharedPreferences.getCachedString(PREF_ENV_URL, "")
        set(value) = sharedPreferences.cacheString(PREF_ENV_URL, value)

    var signatureKey: String // key={sharedSecret}{privateSecret}
        get() = sharedPreferences.getCachedString(PREF_SIGNATURE_KEY, "")
        set(value) = sharedPreferences.cacheString(PREF_SIGNATURE_KEY, value)

    var selectedImagePath: String // key={sharedSecret}{privateSecret}
        get() = sharedPreferences.getCachedString(IMAGE_PATH_KEY, "")
        set(value) = sharedPreferences.cacheString(IMAGE_PATH_KEY, value)
}
