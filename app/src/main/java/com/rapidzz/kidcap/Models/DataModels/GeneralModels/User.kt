package com.rapidzz.kidcap.Models.DataModels.GeneralModels

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



data class User(


    @SerializedName("email")
    @Expose
    val email: String,


    @SerializedName("fcm_token")
    @Expose
    val fcm_token: String,

    @SerializedName("name")
    @Expose
    val name: String?,

    @SerializedName("phone")
    @Expose
    val phone_num: String,


    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("image")
    @Expose
    val image: String?,

    @SerializedName("all_info")
    @Expose
    val all_info:Int?,


    val address:String?,
    val lat:String?,
    val lng:String?,
    val Token: String?=""):Serializable