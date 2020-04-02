package com.rapidzz.kidcap.Views.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.rapidzz.kidcap.R
import com.rapidzz.kidcap.Utils.GeneralUtils.SessionManager

abstract class BaseActivity : AppCompatActivity() {

    lateinit var sessionManager: SessionManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionManager = SessionManager(this)

    }


    abstract fun initViews()
    abstract fun attachViewModel()


}
