package com.rapidzz.garageapp.Views.fragments

import androidx.lifecycle.Observer
import com.rapidzz.garageapp.R
import com.rapidzz.garageapp.Utils.Application.*
import com.rapidzz.garageapp.ViewModels.ProfileViewModel

import kotlinx.android.synthetic.main.fragment_forgot.*

class ChangePasswordFragment : BaseFragment() {


    override fun getLayoutId(): Int {
        return R.layout.fragment_change_password
    }

    lateinit var viewModel: ProfileViewModel


    override fun attachViewModel() {
        viewModel = obtainViewModel(ProfileViewModel::class.java)
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