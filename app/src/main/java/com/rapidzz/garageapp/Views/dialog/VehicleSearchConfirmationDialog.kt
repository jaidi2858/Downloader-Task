package com.rapidzz.garageapp.Views.dialog

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.NumberPicker
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.rapidzz.garageapp.R
import kotlinx.android.synthetic.main.vehicle_search_dialog.view.*
import java.util.*




class VehicleSearchConfirmationDialog(): BaseDialog() {

    override fun getLayoutId(): Int {
        return R.layout.vehicle_search_dialog
    }


    override fun initViews(view: View) {
        view.tvHeading.setText("Hello this is test")
    }
}