package com.junaid.dowloandingtask.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.junaid.dowloandingtask.Models.DataModels.UtilityModels.BaseResponse
import com.junaid.dowloandingtask.Models.DataModels.UtilityModels.ErrorResponse
import com.junaid.dowloandingtask.Utils.GeneralUtils.OneShotEvent
import com.junaid.dowloandingtask.Utils.NetworkUtils.ResultWrapper


open class BaseAndroidViewModel() : ViewModel() {


    val snackbarMessage = MutableLiveData<OneShotEvent<String>>()
    val progressBar = MutableLiveData<OneShotEvent<Boolean>>()




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




    protected fun isSuccess(result:BaseResponse):Boolean {
        if(result.code==200)
        {
            return true
        }
        else
        {
            showSnackbarMessage(result.message)
            return false
        }
    }



    protected fun showProgressBar(show: Boolean) {
        progressBar.value = OneShotEvent(show)
    }


}