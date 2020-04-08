package com.rapidzz.kidcap.Utils.GeneralUtils

import android.content.Context
import android.content.SharedPreferences
import com.rapidzz.kidcap.Models.DataModels.GeneralModels.User
import com.rapidzz.kidcap.Models.Source.ServerConnection.RetrofitClientInstance
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants.Companion.ADDRESS
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants.Companion.EMAIL
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants.Companion.FCM_TOKEN
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants.Companion.IS_LOGGED_IN
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants.Companion.KEY_AUTH
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants.Companion.NAME
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants.Companion.NOTIFY_STATUS
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants.Companion.PHONE_NUMBER
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants.Companion.PREF_NAME
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants.Companion.PROFILE_PIC
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants.Companion.PROFILE_STATUS
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants.Companion.USER_ID

class SessionManager {
    var context: Context? = null
    var pref: SharedPreferences

    constructor(context: Context) {
        this.context = context
        pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun isLoggedIn(): Boolean {
        return pref.getBoolean(IS_LOGGED_IN, false)
    }

    fun setLoggedIn(isLoggedIn: Boolean) {
        with(pref.edit()) {
            putBoolean(IS_LOGGED_IN, isLoggedIn)
            apply()
        }
    }

    fun setUserId(id: String) {
        with(pref.edit()) {
            putString(USER_ID, id)
            apply()
        }
    }

    fun getUserId(): String {
        return pref.getString(USER_ID, "")!!
    }

    fun setName(name: String?) {
        with(pref.edit()) {
            putString(NAME, name)
            apply()
        }
    }

    fun getName(): String {
        return pref.getString(NAME, "")!!
    }

    fun setAddress(address: String?) {
        with(pref.edit()) {
            putString(ADDRESS, address)
            apply()
        }
    }

    fun getAddress(): String {
        return pref.getString(ADDRESS, "")!!
    }



    fun setLat(lat: String?) {
        with(pref.edit()) {
            putString("lat", lat)
            apply()
        }
    }

    fun getLat(): String {
        return pref.getString("lat", "")!!
    }


    fun setLng(lat: String?) {
        with(pref.edit()) {
            putString("lng", lat)
            apply()
        }
    }

    fun getLng(): String {
        return pref.getString("lng", "")!!
    }

    fun setPhoneNumber(phone_num: String?) {
        with(pref.edit()) {
            putString(PHONE_NUMBER, phone_num)
            apply()
        }
    }

    fun getPhoneNumber(): String {
        return pref.getString(PHONE_NUMBER, "")!!
    }

    fun setMobileNumber(value: String?) {
        with(pref.edit()) {
            putString(PHONE_NUMBER, value)
            apply()
        }
    }

    fun getMobileNumber(): String {
        return pref.getString(PHONE_NUMBER, "")!!
    }

    fun setPicture(name: String?) {
        with(pref.edit()) {
            putString(PROFILE_PIC, name)
            apply()
        }
    }

    fun getPicture(): String {
        return pref.getString(PROFILE_PIC, "")!!
    }

    fun setFCMToken(token: String?) {
        with(pref.edit()) {
            putString(FCM_TOKEN, token)
            apply()
        }
    }

    fun getFCMToken(): String {
        return pref.getString(FCM_TOKEN, "")!!
    }

    fun setEmail(email: String?) {
        with(pref.edit()) {
            putString(EMAIL, email)
            apply()
        }
    }

    fun getEmail(): String {
        return pref.getString(EMAIL, "")!!
    }



    fun setInfoStatus(status: Int?) {
        status?.let {
            with(pref.edit()) {
                putInt(PROFILE_STATUS, status)
                apply()
            }
        }

    }

    fun isProfileCompleted(): Boolean {
        return pref.getInt(PROFILE_STATUS,1)==1

    }


    fun setAuthToken(email: String?) {
        with(pref.edit()) {
            putString(KEY_AUTH, email)
            apply()
        }
        RetrofitClientInstance.getInstance(context!!)?.initRetrofit()
    }

    fun getAuthToken(): String {
        return pref.getString(KEY_AUTH, "")!!
    }


    fun logout() {
        setLoggedIn(false)
        setEmail("")
        setUserId("")
        setName("")
        setMobileNumber("")
        setPicture("")
        setAuthToken("")
        setFCMToken("")
        setAddress("")
        setInfoStatus(0)
    }

    fun setUser(u: User) {
        setUserId(u.id.toString())
        setName(u.name)
        setEmail(u.email)
        setLoggedIn(true)
        setAddress(u.address)
        setPhoneNumber(u.phone_num)
        setPicture(u.image)
        setAuthToken(u.Token)
        setInfoStatus(u.all_info)
    }

    fun getLocale(): String {
        return "en"
    }
}