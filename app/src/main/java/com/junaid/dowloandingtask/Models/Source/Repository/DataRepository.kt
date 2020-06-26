package com.junaid.dowloandingtask.Models.Source.Repository

import android.content.Context
import com.junaid.dowloandingtask.Models.DataModels.GeneralModels.Task

import com.junaid.dowloandingtask.Models.DataModels.ResponceModels.LoginResponse

import com.junaid.dowloandingtask.Models.DataModels.UtilityModels.BaseResponse
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK10NAME
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK10URL
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK1NAME
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK1URL
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK2NAME
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK2URL
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK3NAME
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK3URL
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK4NAME
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK4URL
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK5NAME
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK5URL
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK6NAME
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK6URL
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK7NAME
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK7URL
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK8NAME
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK8URL
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK9NAME
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK9URL


import com.junaid.dowloandingtask.Utils.NetworkUtils.ResultWrapper
import com.junaid.dowloandingtask.Utils.NetworkUtils.safeApiCall


class DataRepository(ctx: Context) : BaseRepository(ctx) {


    suspend fun getAllTasks(): ArrayList<Task> {
        var taskList:ArrayList<Task> = ArrayList()
        taskList.add(Task(1,0, TASK1URL,TASK1NAME))
        taskList.add(Task(2,0, TASK2URL,TASK2NAME))
        taskList.add(Task(3,0, TASK3URL,TASK3NAME))
        taskList.add(Task(4,0, TASK4URL,TASK4NAME))
        taskList.add(Task(5,0, TASK5URL,TASK5NAME))
        taskList.add(Task(6,0, TASK6URL,TASK6NAME))
        taskList.add(Task(7,0, TASK7URL,TASK7NAME))
        taskList.add(Task(8,0, TASK8URL,TASK8NAME))
        taskList.add(Task(9,0, TASK9URL,TASK9NAME))
        taskList.add(Task(10,0, TASK10URL,TASK10NAME))
        return taskList

    }


}