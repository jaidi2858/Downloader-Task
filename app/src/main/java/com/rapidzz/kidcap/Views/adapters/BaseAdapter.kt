package com.rapidzz.kidcap.Views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rapidzz.kidcap.R


abstract class BaseAdapter constructor(
    protected var itemList: List<kotlin.Any>,
    private val layoutResId: Int)
    : RecyclerView.Adapter<BaseAdapter.Holder>() {

    override fun getItemCount() = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = itemList[position]
        holder.itemView.bind(item)
    }

    protected abstract fun onItemClick(itemView: View, position: Int)

    protected open fun View.bind(item: Any) {
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)
}