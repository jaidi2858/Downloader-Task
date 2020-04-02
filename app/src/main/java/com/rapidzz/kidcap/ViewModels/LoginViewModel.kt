package com.rapidzz.kidcap.ViewModels


import androidx.lifecycle.MutableLiveData
import com.rapidzz.kidcap.Models.Source.Repository.UserDataSource
import com.rapidzz.kidcap.Models.DataModels.ResponceModels.LoginResponse
import com.rapidzz.kidcap.Models.DataModels.UtilityModels.ApiErrorResponse
import com.rapidzz.kidcap.Models.DataModels.UtilityModels.BaseResponse
import com.rapidzz.kidcap.Models.Source.Repository.DataRepository
import com.rapidzz.kidcap.Models.Source.Repository.ServerDataSource


class LoginViewModel(private val dataRepositery: DataRepository) :
    BaseAndroidViewModel() {


    var userLiveData: MutableLiveData<LoginResponse> = MutableLiveData()
    var changePasswordResponse: MutableLiveData<BaseResponse> = MutableLiveData()
    var dropDownsLiveData: MutableLiveData<BaseResponse> = MutableLiveData()


    fun loginUser(email: String, password: String) {
        showProgressBar(true)
        dataRepositery.loginUser(email, password, object : ServerDataSource.LoginCallback {
            override fun onLogin(login: LoginResponse) {
                showProgressBar(false)
                userLiveData.value = (login)
            }

            override fun onPayloadError(error: ApiErrorResponse) {
                showProgressBar(false)
                showSnackbarMessage(error.message)
            }

        })
    }


}