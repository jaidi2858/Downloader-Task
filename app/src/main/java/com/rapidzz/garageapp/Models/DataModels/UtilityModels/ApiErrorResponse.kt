package com.rapidzz.garageapp.Models.DataModels.UtilityModels

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ApiErrorResponse (
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String
): Serializable