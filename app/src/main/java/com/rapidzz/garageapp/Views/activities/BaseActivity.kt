package com.rapidzz.garageapp.Views.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.rapidzz.garageapp.R
import com.rapidzz.garageapp.Utils.GeneralUtils.DialogUtils
import com.rapidzz.garageapp.Utils.GeneralUtils.SessionManager
import com.rapidzz.garageapp.Views.dialog.AlertMessageDialog
import kotlinx.android.synthetic.main.app_bar_main.*

abstract class BaseActivity : AppCompatActivity() {

    lateinit var sessionManager: SessionManager
    lateinit var dialog: AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.MODE_NIGHT_YES
        setContentView(getLayoutId())
        dialog = DialogUtils.getProgressDialog(this)
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




    fun showAlertDialog(msg: String) {
        var newMessage=msg
        if(newMessage.isEmpty())
        {
            newMessage="Unable to process your request \nPlease try again later !!"
        }
        AlertMessageDialog.newInstance(newMessage).show(this.supportFragmentManager, AlertMessageDialog.TAG)
    }

    fun showProgressDialog(show: Boolean) {

        if (dialog != null && show) {
            if (!dialog.isShowing)
                dialog.apply {
                    show()
                }
        } else if (dialog != null && !show) {
            if (dialog.isShowing)
                dialog.dismiss()
        }
    }

}
