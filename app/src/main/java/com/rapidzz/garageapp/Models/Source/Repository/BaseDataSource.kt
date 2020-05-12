package com.rapidzz.garageapp.Models.DataSource

import com.rapidzz.garageapp.Models.DataModels.UtilityModels.ApiErrorResponse


interface BaseDataSource {
    fun onPayloadError(error: ApiErrorResponse)
}
