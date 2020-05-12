package com.rapidzz.garageapp.Utils.factory

import android.annotation.SuppressLint
import android.app.Application
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rapidzz.garageapp.Models.Source.Repository.DataRepository
import com.rapidzz.garageapp.ViewModels.*

class ViewModelFactory private constructor(private val dataRepository: DataRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {


                isAssignableFrom(LoginViewModel::class.java) ->
                    LoginViewModel(dataRepository)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T

    companion object {

        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application) =
            INSTANCE
                ?: synchronized(ViewModelFactory::class.java) {
                    INSTANCE
                        ?: ViewModelFactory(
                            DataRepository(
                                application.applicationContext
                            )
                        )
                            .also { INSTANCE = it }
                }


        @VisibleForTesting
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
