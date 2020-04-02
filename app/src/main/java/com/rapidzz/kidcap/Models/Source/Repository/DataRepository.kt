package com.rapidzz.kidcap.Models.Source.Repository

import android.annotation.SuppressLint
import android.content.Context
import com.rapidzz.kidcap.Models.DataSource.BaseDataSource
import com.rapidzz.kidcap.Models.Source.ServerConnection.ApiService
import com.rapidzz.kidcap.Models.Source.ServerConnection.RetrofitClientInstance
import com.rapidzz.kidcap.Utils.Application.isOnline
import com.rapidzz.kidcap.Utils.GeneralUtils.AppInstance
import com.rapidzz.kidcap.Utils.GeneralUtils.ErrorUtils

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.rapidzz.kidcap.Models.DataModels.UtilityModels.*
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants
import com.rapidzz.kidcap.Utils.GeneralUtils.SessionManager

import com.rapidzz.kidcap.Utils.Application.enqueue


class DataRepository(ctx: Context) {

    var context: Context
    var sessionManager: SessionManager? = null

    var gson = Gson()

    init {
        context = ctx
        sessionManager = SessionManager(context)
    }




    fun getApiService(): ApiService {
        return RetrofitClientInstance.getInstance(context)!!.getService()
    }


    fun loginUser(userNameOrEmailAddress: String, password: String, callback: ServerDataSource.LoginCallback) {
        if (checkInternetConnection(callback)) return

        var jsonObject = JsonObject()
        jsonObject.addProperty("userNameOrEmailAddress", userNameOrEmailAddress)
        jsonObject.addProperty("password", password)

        getApiService().loginUser(jsonObject).enqueue{
            onSucessResponse={
                if (it.body()!!.code==200) {
                        callback.onLogin(it.body()!!)
                        sessionManager!!.setUser(it.body()!!.result)
                }
                else {
                    callback.onPayloadError(
                        ApiErrorResponse(
                            it.body()!!.code,
                            it.body()!!.message
                        )
                    )
                }
            }
            onErrorResponse={
                callback.onPayloadError(ErrorUtils.parseError(it!!))
            }

            onFailure = {
                callback.onPayloadError(ErrorUtils.parseError(it!!))
            }
        }

    }















    //Utils







    private fun checkInternetConnection(callback: BaseDataSource): Boolean {
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