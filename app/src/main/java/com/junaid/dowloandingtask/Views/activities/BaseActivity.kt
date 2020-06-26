package com.junaid.dowloandingtask.Views.activities

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.junaid.dowloandingtask.Utils.Application.openActivityWithExist
import com.junaid.dowloandingtask.Utils.GeneralUtils.DialogUtils

abstract class BaseActivity : AppCompatActivity() {


    lateinit var dialog: AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.MODE_NIGHT_YES
        setContentView(getLayoutId())
        dialog = DialogUtils.getProgressDialog(this)
        initViews()
    }




    abstract fun getLayoutId():Int
    abstract fun initViews()




    fun gotoMainActivity()
    {
        openActivityWithExist(MainActivity::class.java)

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
