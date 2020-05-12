package com.rapidzz.garageapp.Models.Source.Repository

import kotlin.collections.ArrayList

interface UserDataSource {


    interface OnValidationCallback {
        fun onApplied(isFormValid: Boolean, values: ArrayList<String>)
    }


}