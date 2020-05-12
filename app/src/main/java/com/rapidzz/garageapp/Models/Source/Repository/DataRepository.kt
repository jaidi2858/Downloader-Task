package com.rapidzz.garageapp.Models.Source.Repository

import android.content.Context

import com.rapidzz.garageapp.Models.DataModels.ResponceModels.AllInformationResponse
import com.rapidzz.garageapp.Models.DataModels.ResponceModels.LoginResponse
import com.rapidzz.garageapp.Models.DataModels.ResponceModels.ProfessionsResponse
import com.rapidzz.garageapp.Models.DataModels.ResponceModels.QualificationsResponse

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
        name: String,
        userEmail: String,
        phone: String,
        password: String,
        fcmToken: String
    ): ResultWrapper<LoginResponse> {
        return safeApiCall(dispatcher) {
            getApiService().signupUser(name,userEmail, phone, password,fcmToken,"parent")
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