package com.rapidzz.kidcap.Models.Source.Repository


import com.rapidzz.kidcap.Models.DataModels.ResponceModels.LoginResponse
import com.rapidzz.kidcap.Models.DataModels.UtilityModels.BaseResponse
import com.rapidzz.kidcap.Models.DataSource.BaseDataSource

interface ServerDataSource {


    interface GetGeneralResponseCallback: BaseDataSource {
        fun onSuccess(baseResponse: BaseResponse)
    }


    interface LoginCallback:BaseDataSource{
        fun onLogin(login: LoginResponse)

    }



}