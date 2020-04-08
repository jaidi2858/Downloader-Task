package com.rapidzz.kidcap.Utils.Application

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate


class KidcapApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.MODE_NIGHT_YES
    }


}