package com.rapidzz.kidcap.Views.activities

import android.os.Bundle
import com.rapidzz.kidcap.R
import com.rapidzz.kidcap.ViewModels.LoginViewModel


class RegistrationActivity : BaseActivity() {


    override fun initViews() {

    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_login
    }

    /*   private fun getToken() {
         FirebaseInstanceId.getInstance().instanceId
             .addOnCompleteListener(OnCompleteListener { task ->
                 if (!task.isSuccessful) {
                     return@OnCompleteListener
                 }
                 token = task.result!!.token
                 sessionManager.setFCM(token)
             })
     }*/
}
