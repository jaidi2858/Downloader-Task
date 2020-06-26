package com.junaid.dowloandingtask.Utils.Application


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

import com.junaid.dowloandingtask.R
import com.junaid.dowloandingtask.Utils.factory.ViewModelFactory
import com.junaid.dowloandingtask.Views.dialog.AlertMessageDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
    ViewModelProviders.of(this, ViewModelFactory.getInstance(application)).get(viewModelClass)

fun <T : ViewModel> FragmentActivity.obtainViewModel(viewModelClass: Class<T>) =
    ViewModelProviders.of(this, ViewModelFactory.getInstance(application)).get(viewModelClass)

fun <T : ViewModel> Fragment.obtainViewModel(viewModelClass: Class<T>) =
    ViewModelProviders.of(this, ViewModelFactory.getInstance(this.activity?.application!!)).get(
        viewModelClass
    )






fun<T> Call<T>.enqueue(callback: CallBackKt<T>.() -> Unit) {
    val callBackKt = CallBackKt<T>()
    callback.invoke(callBackKt)
    this.enqueue(callBackKt)
}

class CallBackKt<T>: Callback<T> {

    var onSucessResponse: ((Response<T>) -> Unit)? = null
    var onErrorResponse: ((String?) -> Unit)? = null
    var onFailure: ((t: Throwable?) -> Unit)? = null

    override fun onFailure(call: Call<T>, t: Throwable) {
        onFailure?.invoke(t)
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if(response.isSuccessful)
        {
            if(response.body()!=null)
            {
                onSucessResponse?.invoke(response)
            }
            else if(response.errorBody()!=null)
            {
                onErrorResponse?.invoke(response.errorBody()?.string())
            }
            else
            {
                onFailure?.invoke(Throwable("No error mentioned"))
            }

        }
        else
        {
            onErrorResponse?.invoke(response.errorBody()?.string())
        }
    }

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

fun View.isVisibleToUser():Boolean
{
    return visibility==View.VISIBLE
}






fun Activity.openActivity(clazz: Class<out Activity>) {
    startActivity(Intent(this, clazz))
}

fun Activity.openActivityWithExist(clazz: Class<out Activity>) {
    startActivity(Intent(this, clazz))
    this.finish()
}


fun Activity.openActivityForResult(clazz: Class<out Activity>,requestCode:Int) {
    startActivityForResult(Intent(this, clazz),requestCode)
}



fun Fragment.showAlertDialog(msg: String) {
    var newMessage=msg
    if(newMessage.isEmpty())
    {
        newMessage="Unable to process your request \nPlease try again later !!"
    }
    AlertMessageDialog.newInstance(newMessage).show(requireActivity().supportFragmentManager, AlertMessageDialog.TAG)
}

fun FragmentActivity.showAlertDialog(msg: String) {
    var newMessage=msg
    if(newMessage.isEmpty())
    {
        newMessage="Unable to process your request \nPlease try again later !!"
    }
    AlertMessageDialog.newInstance(newMessage).show(supportFragmentManager, AlertMessageDialog.TAG)
}





fun View.showSnackBar( message: String) {
    val snackbar = Snackbar.make(this, message, Snackbar.LENGTH_LONG)
    snackbar.show()
}

fun Activity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}


fun Fragment.showToast(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}












