package com.rapidzz.garageapp.Views.activities

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.TaskExecutors
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import com.rapidzz.garageapp.R
import com.rapidzz.garageapp.Utils.Application.Error
import com.rapidzz.garageapp.Utils.Application.string
import com.rapidzz.garageapp.Utils.GeneralUtils.AppConstants.Companion.MOBILE_PHONE
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
        val mobile = intent.getStringExtra(MOBILE_PHONE)
        sendVerificationCode(mobile!!)

        btnSubmit.setOnClickListener {
            if(!etPinCode.text.isNullOrEmpty()) {
                val code = etPinCode.string().trim({ it <= ' ' })
                if (code.isEmpty() || code.length < 6) {
                    etPinCode.Error("Enter valid code")
                    etPinCode.requestFocus()
                }
                verifyVerificationCode(code)
            }
            else
            {
                etPinCode.Error("Enter valid code")
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


        if(!mVerificationId.isNullOrEmpty()) {
            showProgressDialog(true)
            val credential = PhoneAuthProvider.getCredential(mVerificationId!!, code)
            signInWithPhoneAuthCredential(credential)
        }
        else
        {
            var message = "Could not be verified \n" +
                    " Please try again using resend"
            showAlertDialog(message)
        }
    }


    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        mAuth!!.signInWithCredential(credential)
            .addOnCompleteListener(this@PhoneVerificationActivity,
                OnCompleteListener<AuthResult> { task ->
                    showProgressDialog(false)
                    if (task.isSuccessful) {

                        sendResultBackToSignup()
                    } else {
                        var message = "Something is wrong, we will fix it soon..."

                        if (task.exception is FirebaseAuthInvalidCredentialsException) {
                            message = "Invalid code entered..."
                        }

                        showAlertDialog(message)
                    }
                })


    }


    private fun sendResultBackToSignup() {
        val resultIntent = Intent()
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }







}
