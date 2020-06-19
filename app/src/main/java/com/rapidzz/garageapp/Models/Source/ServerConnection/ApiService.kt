package com.rapidzz.garageapp.Models.Source.ServerConnection


import com.rapidzz.garageapp.Models.DataModels.ResponceModels.*
import com.rapidzz.garageapp.Models.DataModels.UtilityModels.BaseResponse
import com.rapidzz.garageapp.Utils.GeneralUtils.AppConstants.Companion.CHANGE_PASSWORD
import com.rapidzz.garageapp.Utils.GeneralUtils.AppConstants.Companion.COMPLETE_INFO
import com.rapidzz.garageapp.Utils.GeneralUtils.AppConstants.Companion.FORGOT_PASSWORD
import com.rapidzz.garageapp.Utils.GeneralUtils.AppConstants.Companion.GET_PROFILE
import com.rapidzz.garageapp.Utils.GeneralUtils.AppConstants.Companion.LOGOUT_API
import com.rapidzz.garageapp.Utils.GeneralUtils.AppConstants.Companion.PROFESSIONS
import com.rapidzz.garageapp.Utils.GeneralUtils.AppConstants.Companion.QUALIFICATIONS
import com.rapidzz.garageapp.Utils.GeneralUtils.AppConstants.Companion.SIGNIN_API
import com.rapidzz.garageapp.Utils.GeneralUtils.AppConstants.Companion.SIGNUP_API
import com.rapidzz.garageapp.Utils.GeneralUtils.AppConstants.Companion.UPDATE_FCM
import com.rapidzz.garageapp.Utils.GeneralUtils.AppConstants.Companion.UPDATE_PASSWORD
import com.rapidzz.garageapp.Utils.GeneralUtils.AppConstants.Companion.VERIFY_CODE
import retrofit2.http.*

@JvmSuppressWildcards
interface ApiService {


    @FormUrlEncoded
    @POST(SIGNIN_API)
    suspend fun loginUser(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("fcm_token") token: String
    ): LoginResponse

    @FormUrlEncoded
    @POST(SIGNUP_API)
    suspend fun signupUser(
        @Field("first_name") first_name: String,
        @Field("last_name") last_name: String,
        @Field("email") email: String,
        @Field("phone") phone: String,
        @Field("password") password: String,
        @Field("fcm_token") fcm_token: String,
        @Field("user_type") user_type: String,
        @Field("cnic") cnic: String,
        @Field("address") address: String,
        @Field("city") city: String,
        @Field("country") country: String,
        @Field("lat") lat: String,
        @Field("lng") lng: String

    ): LoginResponse


    @FormUrlEncoded
    @POST(LOGOUT_API)
    suspend fun userLogout(
        @Field("user_id") user_id: String
    ): BaseResponse


    @FormUrlEncoded
    @POST(CHANGE_PASSWORD)
    suspend fun changePassword(
        @Field("user_id") user_id: String,
        @Field("current_password") current_password: String,
        @Field("new_password") new_password: String
    ): BaseResponse



    @FormUrlEncoded
    @POST(FORGOT_PASSWORD)
    suspend fun forgotPassword(
        @Field("email") email: String
    ): BaseResponse



    @FormUrlEncoded
    @POST(VERIFY_CODE)
    suspend fun verifyCode(
        @Field("email") email: String,
        @Field("code") code: String
    ): BaseResponse




    @FormUrlEncoded
    @POST(UPDATE_PASSWORD)
    suspend fun updatePassword(
        @Field("email") email: String,
        @Field("password") password: String
    ): BaseResponse


    @FormUrlEncoded
    @POST(GET_PROFILE)
    suspend fun getProfile(
        @Field("user_id") user_id: String
    ): LoginResponse


    @FormUrlEncoded
    @POST(UPDATE_FCM)
    suspend fun updateFCMToken(
        @Field("user_id") user_id: String,
        @Field("fcm_token") fcm_token: String
    ): BaseResponse



    @GET(QUALIFICATIONS)
    suspend fun getQualifications(): QualificationsResponse



    @GET(PROFESSIONS)
    suspend fun getProfessions(): ProfessionsResponse








}