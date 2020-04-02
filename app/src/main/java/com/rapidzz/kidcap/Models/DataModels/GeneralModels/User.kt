package com.rapidzz.kidcap.Models.DataModels.GeneralModels

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



data class User(

    val email: String,
    val fcm_token: String,
    val image: String,
    val name: String,
    val phone_num: Any,
    val id: Int,
    val notification_status:Int,
    val address:String,
    val lat:String,
    val lng:String,
    val Token: String=""):Serializable