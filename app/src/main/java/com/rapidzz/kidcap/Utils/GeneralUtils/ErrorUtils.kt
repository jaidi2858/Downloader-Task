package com.rapidzz.kidcap.Utils.GeneralUtils

import android.util.Log
import com.rapidzz.kidcap.Models.DataModels.UtilityModels.ApiErrorResponse
import org.json.JSONObject

object ErrorUtils {
    fun parseError(apiError: String): ApiErrorResponse {
        Log.d("apierror",apiError)
        try {
            val json = JSONObject(apiError)
            val error = ApiErrorResponse(
                    json.optInt("code", 0),
                    json.optString("message", "")
                )
            return error
        }catch (ex: Exception){
            ex.printStackTrace()
            return ApiErrorResponse(
                0,
                ""
            )
        }
    }



    fun parseError(t: Throwable): ApiErrorResponse {
        try {
            return ApiErrorResponse(
                0,
                t.message!!
            )
        }catch (ex: Exception){
            ex.printStackTrace()
            return ApiErrorResponse(
                0,
                ""
            )
        }
    }
}