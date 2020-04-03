package com.rapidzz.kidcap.Models.Source.ServerConnection


import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.rapidzz.kidcap.Models.DataModels.GeneralModels.User
import com.rapidzz.kidcap.Models.DataModels.ResponceModels.*
import com.rapidzz.kidcap.Models.DataModels.UtilityModels.BaseResponse
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants.Companion.EMAIL
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants.Companion.FCM_TOKEN
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants.Companion.PASSWORD
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants.Companion.SIGNIN_API
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

@JvmSuppressWildcards
interface ApiService {


    @FormUrlEncoded
    @POST(SIGNIN_API)
    suspend fun loginUser( @Field(EMAIL) email: String,
                           @Field(PASSWORD) password: String,
                           @Field(FCM_TOKEN) token: String): LoginResponse


}