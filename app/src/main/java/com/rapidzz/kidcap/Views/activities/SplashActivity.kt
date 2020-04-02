package com.rapidzz.kidcap.Views.activities

import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.rapidzz.kidcap.R

class SplashActivity : BaseActivity() {

    var token: String = ""

    companion object {
        val SPLASH_DELAY: Long = 3000
        val SKIP_SPLASH: String = "skip_splash"
        val START_UP_MESSAGe: String = "start_up_message"
    }

    var handler: Handler? = null
    var runnable: Runnable? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        setContentView(R.layout.activity_splash)

    }



    override fun initViews() {

    }

    override fun attachViewModel() {
    }
}
