package com.rapidzz.garageapp.Utils.GeneralUtils

class AppConstants {

    companion object {
        val VALID_PHONE_NUMBER: String = "Enter a valid phone number"
        val FIELD_REQUIRED: String = "This field is required"
        val REQUIRED_ERROR: String = "Can't be empty !!"


        // REQUEST CODES
        const val PHONE_CODE = 110
        const val ADDRESS_CODE = 111

        var REQUEST_CODES= intArrayOf(PHONE_CODE,ADDRESS_CODE)



        // POST EXTRAS
        const val MOBILE_PHONE = "mobile_phone"






        // APIS
        const val SIGNIN_API = "user-login"
        const val SIGNUP_API = "user-register"
        const val QUALIFICATIONS = "qualification"
        const val PROFESSIONS = "profession"
        const val COMPLETE_INFO = "parents-info"
        const val LOGOUT_API="user-logout"
        const val CHANGE_PASSWORD="change_password"
        const val FORGOT_PASSWORD="forget_password"
        const val VERIFY_CODE="verify_code"
        const val UPDATE_PASSWORD="update_password"
        const val GET_PROFILE="get_profile"
        const val UPDATE_FCM="update_fcm"





        // Preference name

        const val PREF_NAME = "GarageAppPrefs"
        const val IS_LOGGED_IN = "isLoggedIn"
        const val KEY_AUTH = "auth"
        const val PROFILE_PIC = "image"
        const val ADDRESS = "address"
        const val USER_ID = "user_id"
        const val EMAIL = "email"
        const val FCM_TOKEN = "fcm_token"
        const val PHONE_NUMBER = "phone_num"
        const val IMAGE = "image"
        const val PASSWORD = "password"
        const val FIRST_NAME = "first_name"
        const val LAST_NAME = "last_name"

        const val CATEGORY_ID = "category_id"
        const val NOTIFY_STATUS = "notify_status"
        const val PROFILE_STATUS = "PROFILE_STATUS"

        const val LATITUDE = "lat"
        const val LONGITUDE = "lng"





    }
}