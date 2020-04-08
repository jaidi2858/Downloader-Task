package com.rapidzz.kidcap.Models.Source.ServerConnection


import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.rapidzz.kidcap.Models.DataModels.GeneralModels.User
import com.rapidzz.kidcap.Models.DataModels.ResponceModels.*
import com.rapidzz.kidcap.Models.DataModels.UtilityModels.BaseResponse
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants.Companion.COMPLETE_INFO
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants.Companion.EMAIL
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants.Companion.FCM_TOKEN
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants.Companion.PASSWORD
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants.Companion.PROFESSIONS
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants.Companion.QUALIFICATIONS
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants.Companion.SIGNIN_API
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants.Companion.SIGNUP_API
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
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
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("phone") phone: String,
        @Field("password") password: String,
        @Field("fcm_token") fcm_token: String
    ): LoginResponse



    @GET(QUALIFICATIONS)
    suspend fun getQualifications(): QualificationsResponse



    @GET(PROFESSIONS)
    suspend fun getProfessions(): ProfessionsResponse


    @FormUrlEncoded
    @POST(COMPLETE_INFO)
    suspend fun submitCompleteInfo(
        @Field("parentId") parentId: String?,
        @Field("fatherName") fatherName: String?,
        @Field("motherName") motherName: String?,
        @Field("fatherQualification") fatherQualification: String?,
        @Field("motherQualification") motherQualification: String?,
        @Field("fatherContact") fatherContact: String?,
        @Field("motherContact") motherContact: String?,
        @Field("fatherEmail") fatherEmail: String?,
        @Field("motherEmail") motherEmail: String?,
        @Field("fatherProfession") fatherProfession: String?,
        @Field("motherProfession") motherProfession: String?,
        @Field("fatherDesignation") fatherDesignation: String?,
        @Field("motherDesignation") motherDesignation: String?,
        @Field("fatherAnnualIncome") fatherAnnualIncome: String?,
        @Field("motherAnnualIncome") motherAnnualIncome: String?,
        @Field("fatherPAN") fatherPAN: String?,
        @Field("motherPAN") motherPAN: String?
    ): AllInformationResponse





}