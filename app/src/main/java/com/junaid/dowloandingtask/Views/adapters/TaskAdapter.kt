package com.junaid.dowloandingtask.Views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.junaid.dowloandingtask.Models.DataModels.GeneralModels.Task
import com.junaid.dowloandingtask.R
import kotlinx.android.synthetic.main.task_progress_layout.view.*


public class TaskAdapter(context:Context,itemList: List<Task>):BaseAdapter(context,itemList, R.layout.task_progress_layout){

    override fun View.bind(item: Any) {
       var singleItem=item as Task
        this.tvTaskName.text=singleItem.taskName+"   (${singleItem.status}) "
        this.taskProgress.progress=singleItem.taskPercentage

    }

    override fun onItemClick(itemView: View, position: Int) {

    }
}