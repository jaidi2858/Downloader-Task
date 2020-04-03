package com.rapidzz.kidcap.ViewModels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.acclivousbyte.gobblecustomer.Utils.GeneralUtils.OneShotEvent
import com.rapidzz.kidcap.Models.DataModels.UtilityModels.BaseResponse
import com.rapidzz.kidcap.Models.DataModels.UtilityModels.ErrorResponse
import com.rapidzz.kidcap.Utils.GeneralUtils.SessionManager
import com.rapidzz.kidcap.Utils.NetworkUtils.ResultWrapper


open class BaseAndroidViewModel() : ViewModel() {


    val snackbarMessage = MutableLiveData<OneShotEvent<String>>()
    val errorResponse = MutableLiveData<OneShotEvent<ErrorResponse>>()
    val progressBar = MutableLiveData<OneShotEvent<Boolean>>()
    val loader = MutableLiveData<OneShotEvent<Boolean>>()




    protected fun showSnackbarMessage(message: String) {
        snackbarMessage.value = OneShotEvent(message)
    }

    protected fun showNetworkError() {
        snackbarMessage.value = OneShotEvent("Internet connection problem")
    }

    protected fun handleErrorType(error:ResultWrapper<Any>) {
        when (error) {
            is ResultWrapper.NetworkError ->
                showNetworkError()
            is ResultWrapper.GenericError ->
                showSnackbarMessage("" + error.error?.message)
        }
    }

    protected fun isSuccess(result:ResultWrapper<Any>):Boolean {
        if((result as BaseResponse).status==200)
        {
            return true
        }
        else
        {
            showSnackbarMessage((result as BaseResponse).message)
            return false
        }
    }



    protected fun showProgressBar(show: Boolean) {
        progressBar.value = OneShotEvent(show)
    }


}