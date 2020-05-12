package com.rapidzz.garageapp.Views.fragments

import com.rapidzz.garageapp.R
import kotlinx.android.synthetic.main.fragment_new_order.*


class NewOrderFragment : BaseFragment(){



    override fun getLayoutId(): Int {
        return R.layout.fragment_new_order
    }

    override fun attachViewModel() {}



    override fun initViews() {
        btnLookup.setOnClickListener{
            navigateRegFragment(
                R.id.action_startedFragment_to_signupFragment,
                null
            )
        }

        btnGo.setOnClickListener {
            navigateRegFragment(
                R.id.action_startedFragment_to_signInFragment,
                null
            )
        }

    }
}