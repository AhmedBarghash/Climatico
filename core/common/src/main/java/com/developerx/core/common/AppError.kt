package com.developerx.core.common

/**
 * please read the following blog:
 * https://www.droidcon.com/2021/12/29/considering-all-unhappy-paths-in-a-type-safe-way-in-modern-android/
 */

sealed interface AppError
sealed interface ApiError : AppError
data class UnAuthorized(val code: Int = 401, val message: String, val request: String) : ApiError
data class Forbidden(val code: Int = 403, val message: String, val request: String) : ApiError
data class NotFound(val code: Int = 404, val message: String, val request: String) : ApiError
data class TooManyRequest(val code: Int = 429, val message: String, val request: String) : ApiError
data class InternalServerError(
    val code: Int = 500,
    val message: String,
    val request: String
) : ApiError
data class NotImplemented(val code: Int = 501, val message: String, val request: String) : ApiError
data class BadGateway(val code: Int = 502, val message: String, val request: String) : ApiError
data class ServiceUnAvailable(
    val code: Int = 503,
    val message: String,
    val request: String
) : ApiError
data class Unknown(
    val code: Int,
    val message: String,
    val cause: Throwable?,
    val request: String
) : ApiError
