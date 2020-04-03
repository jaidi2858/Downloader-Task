package com.rapidzz.tawridcustomer.view.fragments.registration

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.rapidzz.kidcap.Models.Source.Repository.UserDataSource
import com.rapidzz.kidcap.R
import com.rapidzz.kidcap.Utils.Application.isEmailValid
import com.rapidzz.kidcap.Utils.Application.obtainViewModel
import com.rapidzz.kidcap.ViewModels.LoginViewModel
import com.rapidzz.kidcap.Views.activities.BaseActivity
import com.rapidzz.kidcap.Views.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_sigin_in.*

class SignInFragment : BaseFragment(){



    override fun getLayoutId(): Int {
        return R.layout.fragment_sigin_in
    }

    lateinit var viewModel: LoginViewModel





    private fun applyValidations()
    {
        var validateViews:ArrayList<View> = ArrayList()
        validateViews.add(etEmailOrUsername)
        validateViews.add(etPassword)
        applyValidations(validateViews,btnLogin,object: UserDataSource.OnValidationCallback{
            override fun onApplied(isFormValid: Boolean, values: ArrayList<String>) {
                if(isFormValid && etEmailOrUsername.isEmailValid())
                {
                    viewModel.loginUser( etEmailOrUsername.text.toString(),
                        etPassword.text.toString(),
                        sessionManager.getFCMToken())
                }
                else if(!etEmailOrUsername.isEmailValid())
                {
                    etEmailOrUsername.setError(getString(R.string.invalid_email))
                    etEmailOrUsername.requestFocus()
                }
            }
        })



    }

    override fun attachViewModel() {
        viewModel = obtainViewModel(LoginViewModel::class.java)

        with(viewModel)
        {
            progressBar.observe(viewLifecycleOwner, Observer {
                val show = it.getContentIfNotHandled()
                if (show != null) {
                    showProgressDialog(show)
                }
            })
            snackbarMessage.observe(viewLifecycleOwner, Observer {
                val msg = it.getContentIfNotHandled()
                if (!msg.isNullOrEmpty()) {
                    showAlertDialog(msg)
                }
            })

            userLiveData.observe(viewLifecycleOwner, Observer {
                sessionManager.setUser(it)
                (activity as BaseActivity).gotoMainActivity()
            })
        }

    }



    override fun initViews() {
        tvForgetPassword.setOnClickListener{
            navigateRegFragment(
                R.id.action_signInFragment_to_forgotPasswordFragment,
                null
            )
        }

        tvSignup.setOnClickListener {
            navigateRegFragment(
                R.id.action_signInFragment_to_signupFragment,
                null
            )
        }
        applyValidations()
    }
}