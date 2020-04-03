package com.rapidzz.kidcap.Views.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.rapidzz.kidcap.R

class SplashActivity : BaseActivity() {
    companion object {
        val SPLASH_DELAY: Long = 3000
    }






    override fun initViews() {

        Handler().postDelayed(Runnable {
           gotoRegActivity()
        }, SPLASH_DELAY)
    }

    override fun getLayoutId(): Int {
       return R.layout.activity_splash
    }
}
