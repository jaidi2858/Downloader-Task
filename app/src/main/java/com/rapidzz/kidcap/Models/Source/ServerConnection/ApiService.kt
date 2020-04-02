package com.rapidzz.kidcap.Models.Source.ServerConnection


import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.rapidzz.kidcap.Models.DataModels.ResponceModels.*
import com.rapidzz.kidcap.Models.DataModels.UtilityModels.BaseResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

@JvmSuppressWildcards
interface ApiService {


    @Headers("Content-Type: application/json")
    @POST("/api/TokenAuth/Authenticate")
    fun loginUser(@Body body: JsonObject): Call<LoginResponse>


}