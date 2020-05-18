package com.rapidzz.garageapp.Views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rapidzz.garageapp.R
import com.rapidzz.garageapp.Utils.Application.gone
import com.rapidzz.garageapp.Utils.Application.loadImage
import com.rapidzz.garageapp.Utils.Application.visible
import kotlinx.android.synthetic.main.nav_items_main.view.*
import java.util.*


class UserItemMenuAdapter(context: Context) : RecyclerView.Adapter<UserItemMenuAdapter.ViewHolder>() {

    private val mInflater: LayoutInflater
    var titles = arrayOf(context.getString(R.string.menu_home),context.getString(R.string.menu_my_orders)
        ,context.getString(R.string.menu_payment),context.getString(R.string.menu_profile)
        ,context.getString(R.string.menu_help),context.getString(R.string.menu_logout))
    var images = intArrayOf(R.drawable.ic_home, R.drawable.ic_orders,
        R.drawable.ic_payment, R.drawable.ic_profile,R.drawable.ic_help,R.drawable.ic_logout)
    var context: Context
    var onClickListner:NavItemClickListner ?= null

    init {
        this.mInflater = LayoutInflater.from(context)
        this.context = context
        onClickListner=context as NavItemClickListner
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.nav_items_main, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.loadImage(images[position])
        holder.run {
            name.setText(titles[position])
            itemView.setOnClickListener(View.OnClickListener {
                when (holder.getAdapterPosition()) {



                }
            })
            if(position==4 || position==0)
            {
                mainDivider.visible()
            }
            else
            {

                mainDivider.gone()
            }

            if(position==3)
            {
                line.gone()
            }
            else
            {
                line.visible()
            }
        }
        holder.itemView.setOnClickListener {
            onClickListner?.onclicked(position)
        }
    }

    override fun getItemCount(): Int {
        return titles!!.size
    }

    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        var name = itemView.tvTitle
        var image = itemView.itemImage
        var mainDivider=itemView.mainDivider
        var line=itemView.line

    }


    interface NavItemClickListner{
        fun onclicked(position: Int)
    }
}