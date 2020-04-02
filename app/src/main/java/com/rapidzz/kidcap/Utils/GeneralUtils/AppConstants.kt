package com.rapidzz.kidcap.Utils.GeneralUtils

class AppConstants {

    companion object {
        val VALID_PHONE_NUMBER: String = "Enter a valid phone number"
        val FIELD_REQUIRED: String = "This field is required"
        val REQUIRED_ERROR: String = "Can't be empty !!"



        const val BASE_URL = "http://mashghol.com/tawrid/public/api/v1/restaurant/"
        // api's name
        const val SIGNIN_API = "login"
        const val SIGNUP_API = "register"
        const val UPDATE_FCM_TOKEN_API = "update_fcm_token"
        const val FORGOT_PASSWORD_API = "forgot_password"
        const val GET_CATEGORIES_API = "all-category"
        const val UPDATE_PROFILE_API = "profile-update"
        const val GET_ALL_PRODUCT_API = "all-products"
        const val GET_SUPPLIERS_PRODUCT_API = "get-supplier-products"

        const val PLACE_ORDER_API = "place-order"
        const val SEARCH_PRODUCT_API = "search-products"
        const val ADD_FAVOURITE_API = "add-favourite"
        const val GET_FAVOURITE_List_API = "get-favourite-list"
        const val ORDER_LIST_API = "order-list"
        const val SUB_ORDER_LIST_API = "sub-order-list"
        const val CHANGE_PASSWORD_API = "change-password"
        const val GET_NOTIFICATIONS_API = "complete-notification"
        const val RATE_ORDER = "rating-notification"
        const val PAYMENT_SESSION_API = "payment-intent"
        const val CHANGE_NOTIFY_STATUS = "notification-enabled-disabled"
        const val NEARBY="near-by"





        // param's name
        const val USER_ID = "user_id"
        const val EMAIL = "email"
        const val FCM_TOKEN = "fcm_token"
        const val PHONE_NUMBER = "phone_num"
        const val IMAGE = "image"
        const val PASSWORD = "password"
        const val NAME = "name"
        const val CATEGORY_ID = "category_id"

        const val NOTIFY_STATUS = "notify_status"

        const val SUPPLIER_ID = "supplier_id"

        const val PROFILE_PIC = "image"
        const val CATEGORY = "category"
        const val PRODUCT = "product"
        const val TOTAL_AMOUNT = "total_Amount"
        const val ORDERS = "orders"
        const val PRODUCT_NAME = "product_name"
        const val PRODUCT_ID = "product_id"
        const val ORDER_ID = "order_id"
        const val IS_FAVOURITE = "is_favourite"
        const val LAT = "lat"
        const val LNG = "lng"
        const val ADDRESS = "address"
        const val OLD_PASSWORD = "old_password"
        const val NEW_PASSWORD = "new_password"

        const val notification_id = "notification_id"
        const val rating = "rating"
        const val total = "total"
        const val quantity = "quantity"

        const val notification_status = "notification_status"

        const val LATITUDE = "lat"
        const val LONGITUDE = "lng"

        const val ORDER_DETAIL = "order_detail"

        // Preference name

        const val PREF_NAME = "MyPrefs"
        const val IS_LOGGED_IN = "isLoggedIn"
        const val KEY_AUTH = "auth"




        const val ORDER_PLACED="ORDER_PLACED"
        const val ORDER_ACCEPTED="ORDER_ACCEPTED"
        const val ORDER_REJECTED="ORDER_REJECTED"
        const val ORDER_PREPARING="ORDER_PREPARING"
        const val ORDER_DELIVERED="ORDER_DELIVERED"

        const val EVENT_ITEM="EVENT_ITEM"


        const val PAYMENT_URL="PAYMENT_URL"
        const val SUCCESS_URL="SUCCESS_URL"
        const val FAILURE_URL="FAILURE_URL"
        const val PAYMENT_CODE=1010
        const val PAYMENT_SECRET="PAYMENT_SECRET"
        const val PAYMENT_RESULT="PAYMENT_RESULT"
        const val PAYMENT_AMOUNT="PAYMENT_AMOUNT"


        var IS_ORDER_COMPLETE=false
        var IS_OTHER_PROCESS=false
        var ORDERID=""
    }
}