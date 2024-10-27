package com.developerx.core.data.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject
import com.developerx.base.datamanager.DataManager

class HeadersInterceptor @Inject constructor(
    private val dataManager: DataManager
) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val requestBuilder = original.newBuilder()
        requestBuilder.addHeader("signature", dataManager.signatureKey)
        return chain.proceed(requestBuilder.build())
    }
}
