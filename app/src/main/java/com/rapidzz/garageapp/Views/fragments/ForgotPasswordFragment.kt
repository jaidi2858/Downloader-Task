package com.rapidzz.garageapp.Views.fragments

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.rapidzz.garageapp.R
import com.rapidzz.garageapp.Utils.Application.*
import com.rapidzz.garageapp.ViewModels.LoginViewModel
import com.rapidzz.garageapp.Views.fragments.BaseFragment

import kotlinx.android.synthetic.main.fragment_forgot.*

class ForgotPasswordFragment : BaseFragment() {


    override fun getLayoutId(): Int {
        return R.layout.fragment_forgot
    }

    lateinit var viewModel: LoginViewModel


    override fun attachViewModel() {
        viewModel = obtainViewModel(LoginViewModel::class.java)
        with(viewModel) {
            progressBar.observe(viewLifecycleOwner, Observer {
                val show = it.getContentIfNotHandled()
                if (show != null) showProgressDialog(show)
            })
            snackbarMessage.observe(viewLifecycleOwner, Observer {
                val msg = it.getContentIfNotHandled()
                if (!msg.isNullOrEmpty()) showAlertDialog(msg)
            })

        }
    }


    override fun initViews() {


        btnSendCode.setOnClickListener {
            if (etResetEmail.string().isEmpty() || !etResetEmail.isEmailValid()) {
                etResetEmail.Error(getString(R.string.req_email))
            }
            else {
                llSendInstructions.gone()
                llResetPassword.visible()
                llChangePassword.gone()
                var sentAt = String.format(
                    getString(R.string.the_recovery_code_sent_to),
                    etResetEmail.string()
                )
                tvSentAt.text = sentAt
            }
        }
        btnReset.setOnClickListener {
            if (etRecoveryCode.string().length<6 || etRecoveryCode.string().length>6) {
                etRecoveryCode.Error(getString(R.string.req_code))
            } else {
                llSendInstructions.gone()
                llResetPassword.gone()
                llChangePassword.visible()
              //  viewModel.forgotPassword(etResetEmail.text.toString())
            }
        }

        btnChangePassword.setOnClickListener {

        }
    }
}