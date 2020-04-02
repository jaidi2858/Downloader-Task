package com.rapidzz.kidcap.Views.activities

import android.os.Bundle
import com.rapidzz.kidcap.R
import com.rapidzz.kidcap.ViewModels.LoginViewModel


class LoginActivity : BaseActivity() {


    lateinit var viewModel: LoginViewModel
    var token: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)
    }

    override fun initViews() {

    }

    override fun attachViewModel() {

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
