package com.rapidzz.kidcap.Models.Source.Repository

import android.annotation.SuppressLint
import android.content.Context
import com.rapidzz.kidcap.Models.DataSource.BaseDataSource
import com.rapidzz.kidcap.Models.Source.ServerConnection.ApiService
import com.rapidzz.kidcap.Models.Source.ServerConnection.RetrofitClientInstance
import com.rapidzz.kidcap.Utils.GeneralUtils.ErrorUtils

import com.google.gson.Gson
import com.rapidzz.kidcap.Utils.GeneralUtils.SessionManager
import com.rapidzz.kidcap.Utils.NetworkUtils.isOnline
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


open class BaseRepository(ctx: Context) {

    var context: Context
    var sessionManager: SessionManager? = null
    val dispatcher: CoroutineDispatcher = Dispatchers.IO

    var gson = Gson()

    init {
        context = ctx
        sessionManager = SessionManager(context)

    }




    fun getApiService(): ApiService {
        return RetrofitClientInstance.getInstance(context)!!.getService()
    }



    fun checkInternetConnection(callback: BaseDataSource): Boolean {
        if (!isOnline(context)) {
            callback.onPayloadError(
                ErrorUtils.parseError(
                    "{\"message\":\"Please check internet connection and try again\",\"code\":\"0\",\"name\":\"error\"}"
                )
            )
            return true
        }
        return false
    }







}