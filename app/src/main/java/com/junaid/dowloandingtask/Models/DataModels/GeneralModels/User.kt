package com.junaid.dowloandingtask.Models.DataModels.GeneralModels

data class User(
    val address: String,
    val city: String,
    val cnic: String,
    val country: String,
    val email: String,
    val fcm_token: String,
    val first_name: String,
    val id: Int,
    val image: String,
    val last_name: String,
    val lat: String,
    val lng: String,
    val phone: String,
    val token: String,
    val user_type: String
)