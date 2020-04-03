package com.rapidzz.kidcap.Views.activities

import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.rapidzz.kidcap.R

class SplashActivity : BaseActivity() {
    companion object {
        val SPLASH_DELAY: Long = 3000
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

    }



    override fun initViews() {

    }

    override fun getLayoutId(): Int {
       return R.layout.activity_splash
    }
}
