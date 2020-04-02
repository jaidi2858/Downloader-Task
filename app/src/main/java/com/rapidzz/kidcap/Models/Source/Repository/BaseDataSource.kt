package com.rapidzz.kidcap.Models.DataSource

import com.rapidzz.kidcap.Models.DataModels.UtilityModels.ApiErrorResponse


interface BaseDataSource {
    fun onPayloadError(error: ApiErrorResponse)
}
