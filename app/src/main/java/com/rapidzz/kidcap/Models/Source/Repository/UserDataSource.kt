package com.rapidzz.kidcap.Models.Source.Repository

import com.google.gson.JsonObject
import kotlin.collections.ArrayList

interface UserDataSource {


    interface OnValidationCallback {
        fun onApplied(isFormValid: Boolean, values: ArrayList<String>)
    }


}