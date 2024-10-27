package com.developerx.core.data.utils

import com.moczul.ok2curl.logger.Logger
import timber.log.Timber

class AndroidLogger : Logger {

    override fun log(message: String) {
        Timber.tag(TAG).v(message)
    }

    companion object {
        const val TAG = "Ok2Curl"
    }
}
