package com.developerx.base.mvi

import android.content.Context
import timber.log.Timber

sealed interface ErrorState : State {

    /**
     * Login error
     * will be used to handle if login process success or not
     *
     * @constructor Create empty Login error
     */
    object LoginError : ErrorState

    /**
     * Un authorized
     *
     * @constructor Create empty Un authorized
     */
    object UnAuthorized : ErrorState

    /**
     * No internet connection
     *
     * @constructor Create empty No internet connection
     */
    object NoInternetConnection : ErrorState

    /**
     * Generic error
     * will be used to handle api issues or crashes
     *
     * @constructor Create empty Generic error
     */
    object GenericError : ErrorState

    /**
     * Persona relation error
     * this class will be used to handle relation cases
     *  1- CG doesn't have any CR assigned to his account
     *  2- ICG doesn't have any CR assigned to his account
     *
     * @constructor Create empty Persona relation error
     */
    object PersonaRelationError : ErrorState

    /**
     * None
     * to indicate that there is no error
     *
     * @constructor Create empty None
     */
    object None : ErrorState
}

/**
 * Handle error
 * used to handle error from activity or fragment
 * - log error message using logger
 * - show error dialog
 *      - Generic Error Dialog
 *      - Login Error Dialog
 *      - No Internet Connection Dialog
 *      - UnAuthorized Error Dialog
 *
 * @param errorState
 */

fun Context.handleError(errorState: ErrorState) {
    Timber.i("handleError() --> start")
    when (errorState) {
        ErrorState.GenericError -> Timber.i("oops something went wrong...")
        ErrorState.LoginError -> {
            Timber.i("Login Failed...")

        }
        ErrorState.NoInternetConnection -> Timber.i(
            "Please check your internet connection..."
        )

        ErrorState.None -> Timber.i("Error cleared...")
        ErrorState.PersonaRelationError -> Timber.i(
            "There is no relation for this account, Please contact your support"
        )

        ErrorState.UnAuthorized -> Timber.i(
            "You are not authorized, Please Login again to use the application"
        )
    }
}
