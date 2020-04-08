package com.rapidzz.kidcap.Models.Source.Repository

import android.annotation.SuppressLint
import android.content.Context
import com.rapidzz.kidcap.Models.DataSource.BaseDataSource
import com.rapidzz.kidcap.Models.Source.ServerConnection.ApiService
import com.rapidzz.kidcap.Models.Source.ServerConnection.RetrofitClientInstance
import com.rapidzz.kidcap.Utils.GeneralUtils.AppInstance
import com.rapidzz.kidcap.Utils.GeneralUtils.ErrorUtils

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.rapidzz.kidcap.Models.DataModels.GeneralModels.User
import com.rapidzz.kidcap.Models.DataModels.ResponceModels.AllInformationResponse
import com.rapidzz.kidcap.Models.DataModels.ResponceModels.LoginResponse
import com.rapidzz.kidcap.Models.DataModels.ResponceModels.ProfessionsResponse
import com.rapidzz.kidcap.Models.DataModels.ResponceModels.QualificationsResponse
import com.rapidzz.kidcap.Models.DataModels.UtilityModels.*
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants
import com.rapidzz.kidcap.Utils.GeneralUtils.SessionManager

import com.rapidzz.kidcap.Utils.Application.enqueue
import com.rapidzz.kidcap.Utils.NetworkUtils.ResultWrapper
import com.rapidzz.kidcap.Utils.NetworkUtils.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


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
        name: String,
        userEmail: String,
        phone: String,
        password: String,
        fcmToken: String
    ): ResultWrapper<LoginResponse> {
        return safeApiCall(dispatcher) {
            getApiService().signupUser(name,userEmail, phone, password,fcmToken)
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


    suspend fun submitCompleteInfo(
        parentId: String?,
        fatherName: String?,
        motherName: String?,
        fatherQualification: String?,
        motherQualification: String?,
        fatherContact: String?,
        motherContact: String?,
        fatherEmail: String?,
        motherEmail: String?,
        fatherProfession: String?,
        motherProfession: String?,
        fatherDesignation: String?,
        motherDesignation: String?,
        fatherAnnualIncome: String?,
        motherAnnualIncome: String?,
        fatherPAN: String?,
        motherPAN: String?
    ): ResultWrapper<AllInformationResponse> {
        return safeApiCall(dispatcher) {
            getApiService().submitCompleteInfo(parentId,fatherName, motherName, fatherQualification,motherQualification,fatherContact,motherContact,
            fatherEmail,motherEmail,fatherProfession,motherProfession,fatherDesignation,motherDesignation,fatherAnnualIncome,motherAnnualIncome,
            fatherPAN,motherPAN)
        }
    }
}