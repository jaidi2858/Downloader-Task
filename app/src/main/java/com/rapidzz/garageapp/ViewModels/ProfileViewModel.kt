package com.rapidzz.garageapp.ViewModels


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.acclivousbyte.gobblecustomer.Utils.GeneralUtils.OneShotEvent
import com.rapidzz.garageapp.Models.DataModels.GeneralModels.DDItem
import com.rapidzz.garageapp.Models.DataModels.GeneralModels.User
import com.rapidzz.garageapp.Models.DataModels.UtilityModels.BaseResponse
import com.rapidzz.garageapp.Models.Source.Repository.DataRepository
import com.rapidzz.garageapp.Utils.NetworkUtils.ResultWrapper
import kotlinx.coroutines.launch


class ProfileViewModel(private val dataRepositery: DataRepository) :
    BaseAndroidViewModel() {


    //Signup , Login , Profile
    var userLiveData: MutableLiveData<OneShotEvent<User>> = MutableLiveData()

    //Forgot Password
    var forgotPassLiveData: MutableLiveData<OneShotEvent<Boolean>> = MutableLiveData()
    var verifyCodeLiveData: MutableLiveData<OneShotEvent<Boolean>> = MutableLiveData()
    var updatePasswordLiveData: MutableLiveData<OneShotEvent<Boolean>> = MutableLiveData()


    //Change Password
    var changePasswordLiveData: MutableLiveData<OneShotEvent<Boolean>> = MutableLiveData()

    //Change Password
    var userLogoutLiveData: MutableLiveData<OneShotEvent<Boolean>> = MutableLiveData()



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


    fun signupUser( first_name: String,
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
                    lng: String) {
        showProgressBar(true)
        viewModelScope.launch {
            dataRepositery.userSignup(  first_name,
                last_name,
                email,
                phone,
                password,
                fcm_token,
                cnic,
                address,
                city,
                country,
                lat,
                lng)?.let { response ->
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



    fun forgotPassword(email: String) {
        showProgressBar(true)
        viewModelScope.launch {
            dataRepositery.forgotPassword(email)?.let { response ->
                showProgressBar(false)
                when (response) {
                    is ResultWrapper.Success ->
                        if (isSuccess(response.value)) {
                            forgotPassLiveData.value = OneShotEvent(true)
                        }
                    else -> handleErrorType(response)
                }
            }

        }

    }


    fun forgotPassword(email: String,code:String) {
        showProgressBar(true)
        viewModelScope.launch {
            dataRepositery.verifyCode(email,code)?.let { response ->
                showProgressBar(false)
                when (response) {
                    is ResultWrapper.Success ->
                        if (isSuccess(response.value)) {
                            verifyCodeLiveData.value = OneShotEvent(true)
                        }
                    else -> handleErrorType(response)
                }
            }

        }

    }


    fun updatePassword(email: String,newPassword:String) {
        showProgressBar(true)
        viewModelScope.launch {
            dataRepositery.updatePassword(email,newPassword)?.let { response ->
                showProgressBar(false)
                when (response) {
                    is ResultWrapper.Success ->
                        if (isSuccess(response.value)) {
                            updatePasswordLiveData.value = OneShotEvent(true)
                        }
                    else -> handleErrorType(response)
                }
            }

        }

    }


    fun changePassword(oldPassword: String,newPassword:String) {
        showProgressBar(true)
        viewModelScope.launch {
            dataRepositery.changePassword(oldPassword,newPassword)?.let { response ->
                showProgressBar(false)
                when (response) {
                    is ResultWrapper.Success ->
                        if (isSuccess(response.value)) {
                            changePasswordLiveData.value = OneShotEvent(true)
                        }
                    else -> handleErrorType(response)
                }
            }

        }

    }


    fun getProfile() {
        showProgressBar(true)
        viewModelScope.launch {
            dataRepositery.getProfile()?.let { response ->
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


    fun userLogout() {
        showProgressBar(true)
        viewModelScope.launch {
            dataRepositery.logoutUser()?.let { response ->
                showProgressBar(false)
                when (response) {
                    is ResultWrapper.Success ->
                        if (isSuccess(response.value)) {
                            userLogoutLiveData.value = OneShotEvent(true)
                        }
                    else -> handleErrorType(response)
                }
            }

        }

    }




}