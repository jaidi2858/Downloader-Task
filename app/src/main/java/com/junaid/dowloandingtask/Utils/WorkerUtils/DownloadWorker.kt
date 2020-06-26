package com.junaid.dowloandingtask.Utils.WorkerUtils

import android.content.Context
import android.os.Environment
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.junaid.dowloandingtask.Models.DataModels.GeneralModels.Task
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK_COMPLETED
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK_FAILED
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK_ID
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK_IN_PROGRESS
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK_NAME
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK_URL
import com.junaid.dowloandingtask.Utils.WorkerUtils.LiveDataHelper.Companion.downloaderInstance
import org.greenrobot.eventbus.EventBus
import java.io.File
import java.io.FileOutputStream
import java.net.HttpURLConnection
import java.net.URL

class DownloadWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {


    private var liveDataHelper: LiveDataHelper? = null
    var filesPath = Environment.getExternalStorageDirectory().path + "/TASKFILES/"


    init {
        liveDataHelper = downloaderInstance
    }

    override fun doWork(): Result {
        val taskURL = inputData.getString(TASK_URL)
        val taskName = inputData.getString(TASK_NAME)
        val taskId = inputData.getInt(TASK_ID, 0)
        val task = Task(taskId, 0, taskURL!!, taskName!!)
        task.taskPercentage=0
        task.status=TASK_IN_PROGRESS
        liveDataHelper?.updateDownloadPer(task)
        try {
            File(filesPath).mkdir();
            val outputFile = File(filesPath + taskName);
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }
            val url = URL(taskURL)
            val urlConnection = url.openConnection() as HttpURLConnection
            urlConnection.setRequestProperty("Accept-Encoding", "identity");
            urlConnection.connect()
            val fileLength = urlConnection.getContentLength()
            val fos = FileOutputStream(outputFile)
            val inputStream = urlConnection.getInputStream()
            val buffer = ByteArray(1024)
            var len1: Int
            var total: Long = 0
            while (inputStream.read(buffer).also { len1 = it } > 0) {
                total += len1.toLong()
                val percentage = (total * 100 / fileLength).toInt()
                task.taskPercentage = percentage
                task.status=TASK_IN_PROGRESS
                liveDataHelper?.updateDownloadPer(task)
                fos.write(buffer, 0, len1)
            }
            fos.close()
            inputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
            task.status= TASK_FAILED
            task.taskPercentage=0
            EventBus.getDefault().post(task)
            return Result.failure()

        }
        task.taskPercentage=100
        task.status=TASK_COMPLETED
        EventBus.getDefault().post(task)
        return Result.success()
    }

}