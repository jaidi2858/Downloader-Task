package com.rapidzz.garageapp.Views.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.rapidzz.garageapp.R
import com.rapidzz.garageapp.Utils.GeneralUtils.SessionManager
import kotlinx.android.synthetic.main.app_bar_main.*

abstract class BaseActivity : AppCompatActivity() {

    lateinit var sessionManager: SessionManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.MODE_NIGHT_YES
        setContentView(getLayoutId())

        sessionManager = SessionManager(this)
        initViews()
    }




    abstract fun getLayoutId():Int
    abstract fun initViews()




    fun gotoMainActivity()
    {
        startActivity(Intent(this,MainActivity::class.java))
        this?.finish()
    }


    fun gotoRegActivity()
    {
        startActivity(Intent(this,RegistrationActivity::class.java))
        this?.finish()
    }




}
