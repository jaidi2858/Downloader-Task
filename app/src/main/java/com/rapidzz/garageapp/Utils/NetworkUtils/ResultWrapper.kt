package com.rapidzz.garageapp.Utils.NetworkUtils

import com.rapidzz.garageapp.Models.DataModels.UtilityModels.ApiErrorResponse

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T): ResultWrapper<T>()
    data class GenericError(val code: Int? = null, val error: ApiErrorResponse? = null): ResultWrapper<Nothing>()
    object NetworkError: ResultWrapper<Nothing>()
}