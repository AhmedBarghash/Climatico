package com.developerx.core.data.extensions

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.developerx.core.common.ResultOf
import com.developerx.core.common.BadGateway
import com.developerx.core.common.Forbidden
import com.developerx.core.common.InternalServerError
import com.developerx.core.common.NotFound
import com.developerx.core.common.NotImplemented
import com.developerx.core.common.ServiceUnAvailable
import com.developerx.core.common.TooManyRequest
import com.developerx.core.common.UnAuthorized
import com.developerx.core.common.Unknown
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import timber.log.Timber
import java.io.File

fun <T> Response<T>.toFlow() = flow {
    emit(
        when (isSuccessful) {
            true -> ResultOf.Success(body() as T)
            false -> {
                val request = raw().request.toString()
                val appError = when (code()) {
                    401 -> UnAuthorized(
                        message = errorBody()?.toErrorObject()?.message ?: "UnAuthorized...",
                        request = request
                    )

                    403 -> Forbidden(
                        message = message(),
                        request = request
                    )

                    404 -> NotFound(
                        message = message(),
                        request = request
                    )

                    429 -> TooManyRequest(
                        message = message(),
                        request = request
                    )

                    500 -> InternalServerError(
                        message = message(),
                        request = request
                    )

                    501 -> NotImplemented(
                        message = message(),
                        request = request
                    )

                    502 -> BadGateway(
                        message = message(),
                        request = request
                    )

                    503 -> ServiceUnAvailable(
                        message = message(),
                        request = request
                    )

                    else -> Unknown(
                        code = code(),
                        message = errorBody()?.string() ?: "Failed",
                        cause = Throwable(errorBody()?.string()),
                        request = request
                    )
                }
                Timber.e(appError.toString())
                ResultOf.Error(appError)
            }
        }
    )
}.catch { throwable ->
    emit(
        ResultOf.Error(
            Unknown(
                code(),
                "Api Failed",
                throwable,
                raw().request.toString()
            )
        )
    )
}

fun String?.toMultipart(): MultipartBody.Part? {
    if (this == null || this.isEmpty() || this.isBlank()) {
        return null
    }
    val file = File(this)
    val mimeType = if (file.name.endsWith(".png", true)) "image/png"
    else if (file.name.endsWith("jpg", true) || file.name.endsWith(
            "jpeg",
            true
        )
    ) "image/jpeg" else "multipart/form-data"

    val requestFile: RequestBody =
        file.asRequestBody(mimeType.toMediaTypeOrNull())
    return MultipartBody.Part.createFormData("receipt", file.name, requestFile)
}

fun ResponseBody.toErrorObject(): ClError {
    val gson = Gson()
    val type = object : TypeToken<ClError>() {}.type
    return gson.fromJson(this.charStream(), type)
}

data class ClError(val message: String)
