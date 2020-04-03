package com.rapidzz.kidcap.Views.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.TaskExecutors
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import com.rapidzz.kidcap.R
import kotlinx.android.synthetic.main.activity_phone_verification.*
import kotlinx.android.synthetic.main.toolbar_layout.*
import java.util.concurrent.TimeUnit

class PhoneVerificationActivity : BaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_phone_verification
    }

    private var mAuth: FirebaseAuth? = null

    private var mVerificationId: String? = null


    override fun initViews() {
        mAuth = FirebaseAuth.getInstance()


        ivBack.setOnClickListener{ finish() }
        toolbar_title.text=""
        val mobile = intent.getStringExtra("mobile")
        sendVerificationCode(mobile!!)

        btnSubmit.setOnClickListener {
            if(!etPinCode.text.isNullOrEmpty()) {
                val code = etPinCode.getText().toString().trim({ it <= ' ' })
                if (code.isEmpty() || code.length < 6) {
                    etPinCode.setError("Enter valid code")
                    etPinCode.requestFocus()
                }
                verifyVerificationCode(code)
            }
            else
            {
                etPinCode.setError("Enter valid code")
                etPinCode.requestFocus()
            }
        }


        btnResend.setOnClickListener {
            sendVerificationCode(mobile)
        }


    }


    private fun sendVerificationCode(mobile: String) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            mobile,
            60,
            TimeUnit.SECONDS,
            TaskExecutors.MAIN_THREAD,
            mCallbacks
        )
    }


    private val mCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
            val code = phoneAuthCredential.smsCode
            if (code != null) {
                //etPinCode.setText(code)
               // verifyVerificationCode(code)
            }
        }

        override fun onVerificationFailed(e: FirebaseException) {
            Toast.makeText(this@PhoneVerificationActivity, e.message, Toast.LENGTH_LONG).show()
        }

        override fun onCodeSent(
            s: String,
            forceResendingToken: PhoneAuthProvider.ForceResendingToken
        ) {
            super.onCodeSent(s, forceResendingToken)
            mVerificationId = s
        }
    }


    private fun verifyVerificationCode(code: String) {
        //creating the credential
        val credential = PhoneAuthProvider.getCredential(mVerificationId!!, code)

        //signing the user
        signInWithPhoneAuthCredential(credential)
    }


    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        mAuth!!.signInWithCredential(credential)
            .addOnCompleteListener(this@PhoneVerificationActivity,
                OnCompleteListener<AuthResult> { task ->
                    if (task.isSuccessful) {
                        sendResultBackToSignup()
                    } else {
                        var message = "Something is wrong, we will fix it soon..."

                        if (task.exception is FirebaseAuthInvalidCredentialsException) {
                            message = "Invalid code entered..."
                        }
                        Toast.makeText(this@PhoneVerificationActivity, message, Toast.LENGTH_SHORT).show()
                    }
                })


    }


    private fun sendResultBackToSignup() {
        val resultIntent = Intent()
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }


}
