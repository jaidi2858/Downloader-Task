package com.junaid.dowloandingtask.Models.Source.Repository

import android.content.Context
import com.junaid.dowloandingtask.Models.DataSource.BaseDataSource
import com.junaid.dowloandingtask.Models.Source.ServerConnection.ApiService
import com.junaid.dowloandingtask.Models.Source.ServerConnection.RetrofitClientInstance
import com.junaid.dowloandingtask.Utils.GeneralUtils.ErrorUtils

import com.google.gson.Gson
import com.junaid.dowloandingtask.Utils.NetworkUtils.isOnline
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


open class BaseRepository(ctx: Context) {

    var context: Context
    val dispatcher: CoroutineDispatcher = Dispatchers.IO
    var userId:String =""

    var gson = Gson()

    init {
        context = ctx

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