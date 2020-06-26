package com.junaid.dowloandingtask.Views.activities

import android.Manifest
import android.content.Context
import android.os.Build
import android.os.Handler
import com.junaid.dowloandingtask.R
import com.junaid.dowloandingtask.Utils.Application.showAlertDialog
import com.nabinbhandari.android.permissions.PermissionHandler
import com.nabinbhandari.android.permissions.Permissions

class SplashActivity : BaseActivity() {
    companion object {
        val SPLASH_DELAY: Long = 3000
    }


    override fun initViews() {
        checkFileRequirments()
    }

    override fun getLayoutId(): Int {
       return R.layout.activity_splash
    }





    private fun checkFileRequirments()
    {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            gotoDownloaderTask()
        }
        else {
            val permissions = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE)
            Permissions.check(this, permissions, null, null, object : PermissionHandler() {
                override fun onGranted() {
                    gotoDownloaderTask()
                }

                override fun onDenied(context: Context?, deniedPermissions: ArrayList<String>?) {
                    super.onDenied(context, deniedPermissions)
                    showAlertDialog("Permissions required to run application")
                }
            })
        }

    }



    private fun gotoDownloaderTask()
    {
        Handler().postDelayed(Runnable {
            gotoMainActivity()
        }, SPLASH_DELAY)
    }
}
