package com.rapidzz.garageapp.Models.Source.Repository


import com.rapidzz.garageapp.Models.DataModels.ResponceModels.LoginResponse
import com.rapidzz.garageapp.Models.DataModels.UtilityModels.BaseResponse
import com.rapidzz.garageapp.Models.DataSource.BaseDataSource

interface ServerDataSource {


    interface GetGeneralResponseCallback: BaseDataSource {
        fun onSuccess(baseResponse: BaseResponse)
    }


    interface LoginCallback:BaseDataSource{
        fun onLogin(login: LoginResponse)

    }



}