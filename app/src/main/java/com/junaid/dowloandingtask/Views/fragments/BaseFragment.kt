package com.junaid.dowloandingtask.Views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.junaid.dowloandingtask.Models.DataModels.GeneralModels.Task
import com.junaid.dowloandingtask.R
import com.junaid.dowloandingtask.Utils.GeneralUtils.DialogUtils
import com.junaid.dowloandingtask.Views.activities.MainActivity
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


abstract class BaseFragment : Fragment() {

    lateinit var dialog: AlertDialog





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dialog = DialogUtils.getProgressDialog(requireContext())

    }


    abstract fun initViews()

    abstract fun attachViewModel()





    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(), container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        attachViewModel()


    }

    abstract fun getLayoutId():Int









    fun navigateToFragment(action: Int, bundle: Bundle?) {
            val navController = Navigation.findNavController(
                activity as MainActivity,
                R.id.nav_host_fragment
            )
            navController.navigate(action, bundle)
    }





    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }


    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }




    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(task: Task) {
        if(this is StartedFragment) {
            onCompleteTask(task)
        }
    }













}
