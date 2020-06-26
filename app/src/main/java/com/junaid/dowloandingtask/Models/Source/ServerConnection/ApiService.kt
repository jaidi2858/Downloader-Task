package com.junaid.dowloandingtask.Models.Source.ServerConnection


import com.junaid.dowloandingtask.Models.DataModels.ResponceModels.*
import com.junaid.dowloandingtask.Models.DataModels.UtilityModels.BaseResponse
import retrofit2.http.*

@JvmSuppressWildcards
interface ApiService {


    @FormUrlEncoded
    @POST("sign_in")
    suspend fun loginUser(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("fcm_token") token: String
    ): LoginResponse





}