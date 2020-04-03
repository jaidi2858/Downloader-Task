package com.rapidzz.kidcap.Utils.NetworkUtils

import com.rapidzz.kidcap.Models.DataModels.UtilityModels.ApiErrorResponse
import com.rapidzz.kidcap.Models.DataModels.UtilityModels.ErrorResponse

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T): ResultWrapper<T>()
    data class GenericError(val code: Int? = null, val error: ApiErrorResponse? = null): ResultWrapper<Nothing>()
    object NetworkError: ResultWrapper<Nothing>()
}