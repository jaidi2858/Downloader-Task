package com.rapidzz.kidcap.Views.fragments

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.rapidzz.kidcap.Models.Source.Repository.UserDataSource
import com.rapidzz.kidcap.R
import com.rapidzz.kidcap.Utils.Application.*
import com.rapidzz.kidcap.ViewModels.LoginViewModel
import com.rapidzz.kidcap.Views.activities.PhoneVerificationActivity
import kotlinx.android.synthetic.main.fragment_sign_up.*

class SignUpFragment : BaseFragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v) {
            btnVerify->{
                verifyPhone()
            }

        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_sign_up
    }


    override fun initViews() {
        btnVerify.setOnClickListener(this)
        ccp.registerCarrierNumberEditText(etPhoneNumber)
        applyValidations()

    }

    override fun attachViewModel() {

        viewModel = obtainViewModel(LoginViewModel::class.java)
        with(viewModel)
        {
            progressBar.observe(viewLifecycleOwner, Observer {
                it.getContentIfNotHandled()?.let {
                    showProgressDialog(it)
                }
            })

            snackbarMessage.observe(viewLifecycleOwner, Observer {
                it.getContentIfNotHandled()?.let {
                    showAlertDialog(it)
                }
            })

            userLiveData.observe(viewLifecycleOwner, Observer {
                it.getContentIfNotHandled()?.let {
                    sessionManager.setUser(it)
                    showSnackBar(btnRegister,"Success")
                }
            })
        }

    }

    lateinit var viewModel: LoginViewModel



    private fun applyValidations()
    {
        var validateViews:ArrayList<View> = ArrayList()
        validateViews.add(etName)
        validateViews.add(etEmail)
        validateViews.add(etPhoneNumber)
        validateViews.add(etPassword)
        validateViews.add(etReTypePassword)
        applyValidations(validateViews,btnRegister,object:UserDataSource.OnValidationCallback{
            override fun onApplied(isFormValid: Boolean, values: ArrayList<String>) {
                if(isFormValid && isExtraValidated())
                {
                    doSignUp()
                }
            }
        })



    }

    private fun isExtraValidated(): Boolean {
        if (!etEmail.isEmailValid()) {
            etEmail.Error(getString(R.string.invalid_email))
            return false
        }
        else if (btnVerify.isVisibleToUser()) {
            etPhoneNumber.Error(getString(R.string.req_phone_verify))
            return false
        }
        else if (!etReTypePassword.text.toString().equals(etPassword.text.toString(),true)) {
            etReTypePassword.Error(getString(R.string.retype_password))
            return false
        }else
            return true
    }

    private fun doSignUp() {
        viewModel.signupUser(
            etName.string(),
            etPhoneNumber.string(),
            etEmail.text.toString(),
            etPassword.text.toString(),
            sessionManager.getFCMToken()
        )
    }



    private fun verifyPhone()
    {
        if (ccp.isValidFullNumber) {
            val intent = Intent(context, PhoneVerificationActivity::class.java)
            intent.putExtra("mobile", ccp.fullNumberWithPlus)
            activity!!.startActivityForResult(intent, 200)
        } else {
            showToast(getString(R.string.req_phone_verify))

        }
    }




    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode==200 && resultCode==RESULT_OK)
        {
            btnVerify.visibility=View.GONE
            etPhoneNumber.isEnabled=false
            etPhoneNumber.error=null
            rlVerify.visibility=View.GONE
            ccp.isEnabled=false
        }

        super.onActivityResult(requestCode, resultCode, data)

    }
}