package com.junaid.dowloandingtask.ViewModels


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.junaid.dowloandingtask.Models.DataModels.GeneralModels.Task

import com.junaid.dowloandingtask.Models.Source.Repository.DataRepository
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants
import com.junaid.dowloandingtask.Utils.GeneralUtils.OneShotEvent
import com.junaid.dowloandingtask.Utils.WorkerUtils.DownloadWorker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DownloadedViewModel(private val dataRepositery: DataRepository) :
    BaseAndroidViewModel() {

    var jobsLiveData: MutableLiveData<OneShotEvent<ArrayList<Task>>> = MutableLiveData()


    fun getAllTask()
    {
        viewModelScope.launch(Dispatchers.Main)
        {
            jobsLiveData.value=OneShotEvent(dataRepositery.getAllTasks())
        }
    }
}