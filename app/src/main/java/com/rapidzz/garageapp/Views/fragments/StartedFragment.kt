package com.rapidzz.garageapp.Views.fragments

import com.rapidzz.garageapp.R
import kotlinx.android.synthetic.main.fragment_started.*


class StartedFragment : BaseFragment(){



    override fun getLayoutId(): Int {
        return R.layout.fragment_started
    }

    override fun attachViewModel() {}



    override fun initViews() {
        btnGetStarted.setOnClickListener{
            navigateToFragment(
                R.id.action_startedFragment_to_signupFragment,
                null
            )
        }

        llLogin.setOnClickListener {
            navigateToFragment(
                R.id.action_startedFragment_to_signInFragment,
                null
            )
        }

    }
}