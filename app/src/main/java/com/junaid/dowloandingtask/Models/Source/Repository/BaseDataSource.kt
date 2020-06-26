package com.junaid.dowloandingtask.Models.DataSource

import com.junaid.dowloandingtask.Models.DataModels.UtilityModels.ApiErrorResponse


interface BaseDataSource {
    fun onPayloadError(error: ApiErrorResponse)
}
