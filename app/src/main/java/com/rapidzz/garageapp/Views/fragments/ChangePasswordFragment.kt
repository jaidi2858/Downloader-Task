package com.rapidzz.garageapp.Views.fragments

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.rapidzz.garageapp.R
import com.rapidzz.garageapp.Utils.Application.*
import com.rapidzz.garageapp.ViewModels.LoginViewModel
import com.rapidzz.garageapp.Views.fragments.BaseFragment

import kotlinx.android.synthetic.main.fragment_forgot.*

class ChangePasswordFragment : BaseFragment() {


    override fun getLayoutId(): Int {
        return R.layout.fragment_change_password
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

        btnChangePassword.setOnClickListener {

        }
    }
}