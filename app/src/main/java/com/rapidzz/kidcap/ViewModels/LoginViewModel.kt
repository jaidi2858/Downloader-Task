package com.rapidzz.kidcap.ViewModels


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rapidzz.kidcap.Models.DataModels.GeneralModels.User
import com.rapidzz.kidcap.Models.Source.Repository.UserDataSource
import com.rapidzz.kidcap.Models.DataModels.ResponceModels.LoginResponse
import com.rapidzz.kidcap.Models.DataModels.UtilityModels.ApiErrorResponse
import com.rapidzz.kidcap.Models.DataModels.UtilityModels.BaseResponse
import com.rapidzz.kidcap.Models.Source.Repository.DataRepository
import com.rapidzz.kidcap.Models.Source.Repository.ServerDataSource
import com.rapidzz.kidcap.Utils.NetworkUtils.ResultWrapper
import kotlinx.coroutines.launch


class LoginViewModel(private val dataRepositery: DataRepository) :
    BaseAndroidViewModel() {


    var userLiveData: MutableLiveData<User> = MutableLiveData()
    var changePasswordResponse: MutableLiveData<BaseResponse> = MutableLiveData()


    fun loginUser(email: String, password: String,fcmToken:String) {
        showProgressBar(true)
        viewModelScope.launch {
            dataRepositery.userLogin(email,password,fcmToken)?.let {response->
                showProgressBar(false)
                when (response) {
                    is ResultWrapper.Success ->
                        response?.let {
                            it.value?.let {
                                if(it.status==200)
                                {
                                    userLiveData.value=it.data
                                }
                                else
                                {
                                    showSnackbarMessage(it.message)
                                }
                            }
                        }
                    else -> handleErrorType(response)
                }
            }

        }

    }


}