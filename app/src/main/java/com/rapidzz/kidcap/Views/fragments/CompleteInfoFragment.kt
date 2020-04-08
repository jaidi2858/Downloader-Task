package com.rapidzz.kidcap.Views.fragments

import android.view.View
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import com.rapidzz.kidcap.Models.DataModels.GeneralModels.DDItem
import com.rapidzz.kidcap.Models.Source.Repository.UserDataSource
import com.rapidzz.kidcap.R
import com.rapidzz.kidcap.Utils.Application.*
import com.rapidzz.kidcap.ViewModels.LoginViewModel
import com.rapidzz.kidcap.Views.activities.BaseActivity
import kotlinx.android.synthetic.main.fragment_complete_info.*


class CompleteInfoFragment : BaseFragment(){


    override fun getLayoutId(): Int {
        return R.layout.fragment_complete_info
    }


    override fun initViews() {

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

            allProfessions.observe(viewLifecycleOwner, Observer {
                allProfessionsList.clear()
                allProfessionsList.addAll(it)
                setupAdapters()
            })

            allQualifications.observe(viewLifecycleOwner, Observer {
                allQualificationsList.clear()
                allQualificationsList.addAll(it)
            })

            allInfoLiveData.observe(viewLifecycleOwner, Observer {
                it.getContentIfNotHandled()?.let {
                    (activity as BaseActivity).gotoMainActivity()
                }
            })

            getQualificationsProfesions()
        }

    }

    lateinit var viewModel: LoginViewModel
    private var allQualificationsList:ArrayList<DDItem> = ArrayList()
    private var allProfessionsList:ArrayList<DDItem> = ArrayList()



    private fun applyValidations()
    {
        var validateViews:ArrayList<View> = ArrayList()
        validateViews.add(etFName)
        validateViews.add(etFContact)
        validateViews.add(etFEmail)
        validateViews.add(etFQualification)
        validateViews.add(etFProfession)
        validateViews.add(etFDesignation)
        validateViews.add(etFAnuualIcome)
        validateViews.add(etFPAN)

        validateViews.add(etMName)
        validateViews.add(etMContact)
        validateViews.add(etMEmail)
        validateViews.add(etMQualification)
        validateViews.add(etMProfession)
        validateViews.add(etMDesignation)
        validateViews.add(etMAnuualIcome)
        validateViews.add(etMPAN)

        applyValidations(validateViews,btnSubmitDetails,object:UserDataSource.OnValidationCallback{
            override fun onApplied(isFormValid: Boolean, values: ArrayList<String>) {
                if(isFormValid && isExtraValidated())
                {
                    submitInfo()
                }
            }
        })



    }

    private fun isExtraValidated(): Boolean {


        if (!etFEmail.isEmailValid()) {
            etFEmail.Error(getString(R.string.invalid_email))
            return false
        }else if (!etMEmail.isEmailValid()) {
            etMEmail.Error(getString(R.string.invalid_email))
            return false
        }
        else
            return true
    }

    private fun submitInfo() {

        viewModel.submitCompleteInfo(
            sessionManager.getUserId(),
            etFName.string(),
            etMName.string(),""+etFQualification.findId(allQualificationsList),""+etMQualification.findId(allQualificationsList),
            etFContact.string(),etMContact.string(),etFEmail.string(),etMEmail.string(),""+etFProfession.findId(allProfessionsList),
            ""+etMProfession.findId(allProfessionsList),etFDesignation.string(),etMDesignation.string(),etFAnuualIcome.string(),etMAnuualIcome.string(),
            etFPAN.string(),etMPAN.string()
        )
    }



    private fun setupAdapters()
    {
        val qAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, allQualificationsList)
        qAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        etFQualification.threshold=1
        etFQualification?.setAdapter(qAdapter)
        etMQualification.threshold=1
        etMQualification?.setAdapter(qAdapter)
        val pAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, allProfessionsList)
        pAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        etFProfession.threshold=1
        etFProfession?.setAdapter(pAdapter)
        etMProfession.threshold=1
        etMProfession?.setAdapter(pAdapter)
    }






}