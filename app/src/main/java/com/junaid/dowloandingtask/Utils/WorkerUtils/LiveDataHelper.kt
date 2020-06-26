package com.junaid.dowloandingtask.Utils.WorkerUtils

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.junaid.dowloandingtask.Models.DataModels.GeneralModels.Task
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants

class LiveDataHelper private constructor() {
    val downloadTask = MutableLiveData<Task>()
    val downloadCompleteTaskData = MutableLiveData<Int>()
    val downloadFailTaskData = MutableLiveData<Int>()
    fun updateDownloadPer(task: Task) {
        Log.i("Task-Details=","Task-id="+task.taskId+" Status="+task.status+" Percentage="+task.taskPercentage)
        downloadTask.postValue(task)

    }




    companion object {
        private var liveDataHelper: LiveDataHelper? = null

        @JvmStatic
        @get:Synchronized
        val downloaderInstance: LiveDataHelper?
            get() {
                if (liveDataHelper == null) liveDataHelper =
                    LiveDataHelper()
                return liveDataHelper
            }
    }
}