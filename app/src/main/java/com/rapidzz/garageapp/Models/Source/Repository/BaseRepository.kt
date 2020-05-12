package com.rapidzz.garageapp.Models.Source.Repository

import android.content.Context
import com.rapidzz.garageapp.Models.DataSource.BaseDataSource
import com.rapidzz.garageapp.Models.Source.ServerConnection.ApiService
import com.rapidzz.garageapp.Models.Source.ServerConnection.RetrofitClientInstance
import com.rapidzz.garageapp.Utils.GeneralUtils.ErrorUtils

import com.google.gson.Gson
import com.rapidzz.garageapp.Utils.GeneralUtils.SessionManager
import com.rapidzz.garageapp.Utils.NetworkUtils.isOnline
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