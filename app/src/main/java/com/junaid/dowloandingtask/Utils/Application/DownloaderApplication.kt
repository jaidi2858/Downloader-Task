package com.junaid.dowloandingtask.Utils.Application

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.work.Configuration
import java.util.concurrent.Executors


class DownloaderApplication: Application(), Configuration.Provider {



    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.MODE_NIGHT_YES
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setExecutor(Executors.newFixedThreadPool(5))
            .build()
    }
        // provide custom configuration



}