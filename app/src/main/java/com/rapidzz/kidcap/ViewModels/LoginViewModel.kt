package com.rapidzz.kidcap.ViewModels


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.acclivousbyte.gobblecustomer.Utils.GeneralUtils.OneShotEvent
import com.rapidzz.kidcap.Models.DataModels.GeneralModels.AllUserInfo
import com.rapidzz.kidcap.Models.DataModels.GeneralModels.DDItem
import com.rapidzz.kidcap.Models.DataModels.GeneralModels.User
import com.rapidzz.kidcap.Models.DataModels.UtilityModels.BaseResponse
import com.rapidzz.kidcap.Models.Source.Repository.DataRepository
import com.rapidzz.kidcap.Utils.NetworkUtils.ResultWrapper
import kotlinx.coroutines.launch


class LoginViewModel(private val dataRepositery: DataRepository) :
    BaseAndroidViewModel() {


    var userLiveData: MutableLiveData<OneShotEvent<User>> = MutableLiveData()
    var allQualifications: MutableLiveData<ArrayList<DDItem>> = MutableLiveData()
    var allProfessions: MutableLiveData<ArrayList<DDItem>> = MutableLiveData()
    var allInfoLiveData: MutableLiveData<OneShotEvent<AllUserInfo>> = MutableLiveData()
    var changePasswordResponse: MutableLiveData<BaseResponse> = MutableLiveData()


    fun loginUser(email: String, password: String, fcmToken: String) {
        showProgressBar(true)
        viewModelScope.launch {
            dataRepositery.userLogin(email, password, fcmToken)?.let { response ->
                showProgressBar(false)
                when (response) {
                    is ResultWrapper.Success ->
                        if (isSuccess(response.value)) {
                            userLiveData.value = OneShotEvent(response.value.detail)
                        }
                    else -> handleErrorType(response)
                }
            }

        }

    }


    fun signupUser(name: String,phone: String, email: String, password: String, fcmToken: String) {
        showProgressBar(true)
        viewModelScope.launch {
            dataRepositery.userSignup(name,email, phone, password, fcmToken)?.let { response ->
                showProgressBar(false)
                when (response) {
                    is ResultWrapper.Success ->
                        if (isSuccess(response.value)) {
                            userLiveData.value = OneShotEvent(response.value.detail)
                        }
                    else -> handleErrorType(response)
                }
            }

        }

    }


    fun getQualificationsProfesions() {
        showProgressBar(true)
        viewModelScope.launch {
            dataRepositery.getQualifications()?.let { response ->
                showProgressBar(false)
                when (response) {
                    is ResultWrapper.Success ->
                        if (isSuccess(response.value)) {
                            allQualifications.value = response.value.detail
                        }
                    else -> handleErrorType(response)
                }
            }

            showProgressBar(true)
            dataRepositery.getProfesions()?.let { response ->
                showProgressBar(false)
                when (response) {
                    is ResultWrapper.Success ->
                        if (isSuccess(response.value)) {
                            allProfessions.value = response.value.detail
                        }
                    else -> handleErrorType(response)
                }
            }

        }

    }


    fun submitCompleteInfo(
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
    ) {
        showProgressBar(true)
        viewModelScope.launch {
            dataRepositery.submitCompleteInfo(
                parentId,
                fatherName,
                motherName,
                fatherQualification,
                motherQualification,
                fatherContact,
                motherContact,
                fatherEmail,
                motherEmail,
                fatherProfession,
                motherProfession,
                fatherDesignation,
                motherDesignation,
                fatherAnnualIncome,
                motherAnnualIncome,
                fatherPAN,
                motherPAN
            )?.let { response ->
                showProgressBar(false)
                when (response) {
                    is ResultWrapper.Success ->
                        if (isSuccess(response.value)) {
                            allInfoLiveData.value = OneShotEvent(response.value.detail)
                        }
                    else -> handleErrorType(response)
                }
            }

        }

    }


}