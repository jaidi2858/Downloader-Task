package com.rapidzz.kidcap.Models.Source.ServerConnection

import android.content.Context
import com.rapidzz.kidcap.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClientInstance(ctx : Context) {
    private var retrofit: Retrofit? = null
    private val httpClient = OkHttpClient.Builder()
    var context: Context

    val BASE_URL = "http://mashghol.com/tawrid/public/api/v1/restaurant/"

    init {
        context = ctx
        if (retrofit == null) {
            initRetrofit()
        }
    }

    fun initRetrofit(){
        var retrofitBuilder = retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            httpClient.callTimeout(120,TimeUnit.SECONDS).connectTimeout(30,TimeUnit.SECONDS).readTimeout(120,TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val loggingIntercepter = getLoggingInterceptor()
            loggingIntercepter.setLevel(HttpLoggingInterceptor.Level.BODY)
            httpClient.addInterceptor(loggingIntercepter)
        }
        retrofitBuilder.client(httpClient.build())



        retrofit = retrofitBuilder.build()
    }

    fun getService(): ApiService {
        return retrofit!!.create<ApiService>(ApiService::class.java!!)
    }


    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingIntercepter = HttpLoggingInterceptor()
        return loggingIntercepter
    }


    fun getRetrofit(): Retrofit? {
        return retrofit
    }


    companion object {
        var singleInstance: RetrofitClientInstance? = null

        fun getInstance(context: Context): RetrofitClientInstance? {
            if (singleInstance == null)
                singleInstance =
                    RetrofitClientInstance(
                        context
                    )

            return singleInstance
        }
    }


}