package com.rapidzz.garageapp.Views.fragments

import android.view.View
import androidx.lifecycle.Observer
import com.rapidzz.garageapp.Models.Source.Repository.UserDataSource
import com.rapidzz.garageapp.R
import com.rapidzz.garageapp.Utils.Application.Error
import com.rapidzz.garageapp.Utils.Application.errorSet
import com.rapidzz.garageapp.Utils.Application.isEmailValid
import com.rapidzz.garageapp.Utils.Application.obtainViewModel
import com.rapidzz.garageapp.ViewModels.LoginViewModel
import com.rapidzz.garageapp.Views.activities.BaseActivity
import com.rapidzz.garageapp.Views.fragments.BaseFragment
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
                    etEmailOrUsername.Error(getString(R.string.invalid_email))
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
                it.getContentIfNotHandled()?.let {
                    sessionManager.setUser(it)
                        (requireActivity() as BaseActivity).gotoMainActivity()
                }

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
        applyValidations()
    }
}