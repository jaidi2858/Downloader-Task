package com.rapidzz.garageapp.Models.Source.Repository

import android.content.Context

import com.rapidzz.garageapp.Models.DataModels.ResponceModels.LoginResponse
import com.rapidzz.garageapp.Models.DataModels.ResponceModels.ProfessionsResponse
import com.rapidzz.garageapp.Models.DataModels.ResponceModels.QualificationsResponse
import com.rapidzz.garageapp.Models.DataModels.UtilityModels.BaseResponse

import com.rapidzz.garageapp.Utils.NetworkUtils.ResultWrapper
import com.rapidzz.garageapp.Utils.NetworkUtils.safeApiCall


class DataRepository(ctx: Context) : BaseRepository(ctx) {


    suspend fun userLogin(
        userEmail: String,
        password: String,
        fcmToken: String
    ): ResultWrapper<LoginResponse> {
        return safeApiCall(dispatcher) {
            getApiService().loginUser(userEmail, password, fcmToken)
        }
    }


    suspend fun userSignup(
        first_name: String,
        last_name: String,
        email: String,
        phone: String,
        password: String,
        fcm_token: String,
        cnic: String,
        address: String,
        city: String,
        country: String,
        lat: String,
        lng: String
    ): ResultWrapper<LoginResponse> {
        return safeApiCall(dispatcher) {
            getApiService().signupUser(
                first_name,
                last_name,
                email,
                phone,
                password,
                fcm_token,
                "admin",
                cnic,
                address,
                city,
                country,
                lat,
                lng
            )
        }
    }


    suspend fun logoutUser(): ResultWrapper<BaseResponse> {
        return safeApiCall(dispatcher) {
            getApiService().userLogout(userId)
        }
    }


    suspend fun forgotPassword(
        email: String
    ): ResultWrapper<BaseResponse> {
        return safeApiCall(dispatcher) {
            getApiService().forgotPassword(email)
        }
    }


    suspend fun verifyCode(
        email: String,
        code: String
    ): ResultWrapper<BaseResponse> {
        return safeApiCall(dispatcher) {
            getApiService().verifyCode(email, code)
        }
    }

    suspend fun updatePassword(
        email: String,
        password: String
    ): ResultWrapper<BaseResponse> {
        return safeApiCall(dispatcher) {
            getApiService().updatePassword(email, password)
        }
    }


    suspend fun changePassword(
        currentPassword: String,
        newPassword: String
    ): ResultWrapper<BaseResponse> {
        return safeApiCall(dispatcher) {
            getApiService().changePassword(userId, currentPassword, newPassword)
        }
    }


    suspend fun updateFCMToken(
        token: String
    ): ResultWrapper<BaseResponse> {
        return safeApiCall(dispatcher) {
            getApiService().updateFCMToken(userId, token)
        }
    }


    suspend fun getProfile(
    ): ResultWrapper<LoginResponse> {
        return safeApiCall(dispatcher) {
            getApiService().getProfile(userId)
        }
    }


    suspend fun getQualifications(): ResultWrapper<QualificationsResponse> {
        return safeApiCall(dispatcher) {
            getApiService().getQualifications()
        }
    }

    suspend fun getProfesions(): ResultWrapper<ProfessionsResponse> {
        return safeApiCall(dispatcher) {
            getApiService().getProfessions()
        }
    }
}