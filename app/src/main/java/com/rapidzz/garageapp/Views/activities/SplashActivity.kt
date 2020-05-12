package com.rapidzz.garageapp.Views.activities

import android.os.Handler
import com.rapidzz.garageapp.R

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
