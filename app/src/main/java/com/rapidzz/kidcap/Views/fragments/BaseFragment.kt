package com.rapidzz.kidcap.Views.fragments

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.afollestad.vvalidator.form
import com.google.android.material.snackbar.Snackbar
import com.rapidzz.kidcap.Models.Source.Repository.UserDataSource
import com.rapidzz.kidcap.Utils.GeneralUtils.AppConstants
import com.rapidzz.kidcap.Utils.GeneralUtils.DialogUtils
import com.rapidzz.kidcap.Utils.GeneralUtils.SessionManager
import com.rapidzz.kidcap.Views.activities.BaseActivity
import com.rapidzz.kidcap.Views.dialog.AlertMessageDialog
import kotlin.collections.ArrayList


abstract class BaseFragment : Fragment() {

    lateinit var dialog: AlertDialog
    lateinit var sessionManager: SessionManager
    var isForUpdate: Boolean = false


    fun getSimpleName(): String {
        return this.javaClass.simpleName
    }

    fun getColorCustom(color: Int): Int {
        return ContextCompat.getColor(context!!, color)
    }

    fun View.visible() {
        this.visibility = View.VISIBLE
    }


    fun View.invisible() {
        this.visibility = View.INVISIBLE
    }

    fun View.gone() {
        this.visibility = View.GONE
    }




    fun showAlertDialog(msg: String) {
        var newMessage=msg
        if(newMessage.isEmpty())
        {
            newMessage="Unable to process your request \nPlease try again later !!"
        }
        AlertMessageDialog.newInstance(newMessage)
            .show(activity!!.supportFragmentManager, AlertMessageDialog.TAG)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dialog = DialogUtils.getProgressDialog(context!!)
        sessionManager = SessionManager(context!!)

    }


    abstract fun initViews(): Int

    abstract fun attachViewModel()





    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(initViews(), container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isForUpdate = false
            attachViewModel()

    }



    fun showProgressDialog(show: Boolean) {

        if (dialog != null && show) {
            if (!dialog.isShowing)
                dialog.apply {
                    show()
                }
        } else if (dialog != null && !show) {
            if (dialog.isShowing)
                dialog.dismiss()
        }
    }

    fun showSnackBar(view: View, message: String) {
        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
        snackbar.show()
    }

    fun showToast(message: String) {
        Toast.makeText(activity, "Under Development", Toast.LENGTH_SHORT).show()
    }

    fun showToast() {
        Toast.makeText(activity, "Under Development", Toast.LENGTH_SHORT).show()
    }

    public fun isValidEmail(email: String): Boolean {
        val pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }


    fun expand(view: View) {
        val animate = TranslateAnimation(
            0f,
            0f,
            view.height.toFloat(),
            0f
        )
        animate.duration = 500
        animate.fillAfter = true
        view.startAnimation(animate)
        animate.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {

            }

            override fun onAnimationStart(animation: Animation?) {
                view.visible()
            }
        })
    }


    fun collapse(view: View) {
        val animate = TranslateAnimation(
            0f,
            0f,
            0f,
            view.height.toFloat()
        )
        animate.duration = 500
        animate.fillAfter = true
        view.startAnimation(animate)
        animate.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                view.gone()
            }

            override fun onAnimationStart(animation: Animation?) {

            }
        })
    }


    fun applyValidations(
        viewList: ArrayList<View>,
        buttonView: Button,
        callback: UserDataSource.OnValidationCallback
    ) {
        form {
            for (view in viewList) {
                if (view is EditText) {
                    input(view) {
                        isNotEmpty().description("Field Required !")
                    }
                } else if (view is Spinner) {
                    spinner(view) {
                        selection().greaterThan(0)
                        onErrors { view, errors ->
                            if (errors.isNotEmpty()) {
                                showToast("Some selections are missing")
                            }
                        }
                    }
                }
            }

            submitWith(buttonView) { result ->
                var results: ArrayList<String> = ArrayList()
                for (value in result.values()) {
                    results.add(value.asString())
                }
                callback.onApplied(true, results)
            }
        }
    }





}
