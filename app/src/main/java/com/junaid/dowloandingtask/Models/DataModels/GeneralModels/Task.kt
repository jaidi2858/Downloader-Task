package com.junaid.dowloandingtask.Models.DataModels.GeneralModels

data class Task(
    val taskId: Int,
    var taskPercentage: Int,
    val taskUrl:String,
    val taskName:String,
    var status:String= "Pending"
)