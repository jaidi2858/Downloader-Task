package com.rapidzz.kidcap.ViewModels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.acclivousbyte.gobblecustomer.Utils.GeneralUtils.OneShotEvent
import com.rapidzz.kidcap.Models.DataModels.UtilityModels.ErrorResponse
import com.rapidzz.kidcap.Utils.GeneralUtils.SessionManager



open class BaseAndroidViewModel() : ViewModel() {


    val snackbarMessage = MutableLiveData<OneShotEvent<String>>()
    val errorResponse = MutableLiveData<OneShotEvent<ErrorResponse>>()
    val progressBar = MutableLiveData<OneShotEvent<Boolean>>()
    val loader = MutableLiveData<OneShotEvent<Boolean>>()




    protected fun showSnackbarMessage(message: String) {
        snackbarMessage.value = OneShotEvent(message)
    }

    protected fun handleErrorType(errorType: Int, errorMessage: String) {
        val error = ErrorResponse(
            errorMessage,
            errorType
        )
        errorResponse.value = OneShotEvent(error)
    }

    protected fun showProgressBar(show: Boolean) {
        progressBar.value = OneShotEvent(show)
    }


}