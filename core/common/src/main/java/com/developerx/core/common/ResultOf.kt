package com.developerx.core.common

sealed class ResultOf<out T> {

    data class Success<out T>(val data: T) : ResultOf<T>()
    data class Error<T>(val error: AppError) : ResultOf<T>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data: $data]"
            is Error -> "Error[error: $error]"
        }
    }
}

inline fun <reified X> ResultOf<X>.runIfSuccess(action: (X) -> Unit) {
    if (this is ResultOf.Success) {
        action.invoke(this.data)
    }
}

inline fun <reified X> ResultOf<X>.onSuccess(action: (X) -> Unit): ResultOf<X> {
    if (this is ResultOf.Success) {
        action.invoke(this.data)
    }
    return this
}

inline fun <reified X> ResultOf<X>.runIfError(action: (AppError) -> Unit) {
    if (this is ResultOf.Error) {
        action.invoke(this.error)
    }
}

inline fun <reified X> ResultOf<X>.onError(action: (AppError) -> Unit): ResultOf<X> {
    if (this is ResultOf.Error) {
        action.invoke(this.error)
    }
    return this
}
