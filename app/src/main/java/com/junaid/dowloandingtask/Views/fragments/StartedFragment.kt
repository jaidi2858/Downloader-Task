package com.junaid.dowloandingtask.Views.fragments

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.work.*
import com.junaid.dowloandingtask.Models.DataModels.GeneralModels.Task
import com.junaid.dowloandingtask.R
import com.junaid.dowloandingtask.Utils.Application.obtainViewModel
import com.junaid.dowloandingtask.Utils.Application.showAlertDialog
import com.junaid.dowloandingtask.Utils.Application.showToast
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK_ID
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK_NAME
import com.junaid.dowloandingtask.Utils.GeneralUtils.AppConstants.Companion.TASK_URL
import com.junaid.dowloandingtask.Utils.NetworkUtils.isOnline
import com.junaid.dowloandingtask.Utils.WorkerUtils.DownloadWorker
import com.junaid.dowloandingtask.Utils.WorkerUtils.LiveDataHelper.Companion.downloaderInstance
import com.junaid.dowloandingtask.ViewModels.DownloadedViewModel
import com.junaid.dowloandingtask.Views.adapters.TaskAdapter
import kotlinx.android.synthetic.main.fragment_started.*
import java.util.concurrent.Executors


class StartedFragment : BaseFragment() {


    override fun getLayoutId(): Int {
        return R.layout.fragment_started
    }

    override fun attachViewModel() {
        viewModel = obtainViewModel(DownloadedViewModel::class.java)
        with(viewModel)
        {
            this?.jobsLiveData?.observe(viewLifecycleOwner, Observer {
                it.getContentIfNotHandled()?.let { tasks ->
                    if (taskList.isNullOrEmpty()) {
                        taskList.clear()
                        taskList.addAll(tasks)
                        setAdapter()
                    }
                }
            })


            this?.getAllTask()
        }

        downloaderInstance!!.downloadTask.observe(this, Observer {
            onUpdateProgress(it)
        })


    }


    var taskList: ArrayList<Task> = ArrayList()
    var currentTaskPos = 0
    var viewModel: DownloadedViewModel? = null
    var taskAdapter: TaskAdapter? = null


    override fun initViews() {

        val configuration: Configuration = Configuration.Builder()
            .setExecutor(Executors.newFixedThreadPool(5))
            .build()
        WorkManager.initialize(requireContext(), configuration)
        btnGetStarted.setOnClickListener {
            startDownloading()
        }

    }







    private fun startWork(taskList: ArrayList<Task>) {
        val workers:ArrayList<OneTimeWorkRequest> = ArrayList()
        for(task in taskList) {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresStorageNotLow(true)
                .build();
            val data: Data.Builder = Data.Builder()
            data.putString(TASK_URL, task.taskUrl)
            data.putInt(TASK_ID, task.taskId)
            data.putString(TASK_NAME, task.taskName)

            val oneTimeWorkRequest = OneTimeWorkRequest.Builder(DownloadWorker::class.java)
                .setConstraints(constraints)
                .setInputData(data.build())
                .build();
            workers.add(oneTimeWorkRequest)
        }
        WorkManager.getInstance(requireContext()).enqueue(workers);
    }



    private fun onUpdateProgress(task: Task) {
            val previousTask = taskList.find { it.taskId == task.taskId }
            val position = taskList.indexOf(previousTask)
            taskList[position].taskPercentage = task.taskPercentage
            taskList[position].status = task.status
            taskAdapter?.notifyDataSetChanged()
    }



     fun onCompleteTask(task: Task)
    {
        if (currentTaskPos != taskList.size) {
            startWork(ArrayList(taskList.subList(currentTaskPos,currentTaskPos+1)))
            currentTaskPos++;
        }

        val previousTask = taskList.find { it.taskId == task.taskId }
        val position = taskList.indexOf(previousTask)
        taskList[position].taskPercentage = 100
        taskList[position].status = task.status
        // taskAdapter?.notifyItemChanged(position)  Causing overlap issue
        taskAdapter?.notifyDataSetChanged()
    }




    private fun setAdapter() {
        taskAdapter = TaskAdapter(requireContext(),taskList)
        with(rvAllTasks)
        {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = taskAdapter
        }

    }











    private fun startDownloading() {
        if(!isOnline(requireContext()))
        {
           showAlertDialog("Please check your internet connection and try again")
        }
        else {
            showToast("Downloading started")
            if (!taskList.isNullOrEmpty()) {
                startWork(ArrayList(taskList.subList(0,5)))
                btnGetStarted.isEnabled = false
                currentTaskPos = 5
            }
        }
    }









}