package com.rapidzz.garageapp.Models.DataModels.ResponceModels


import com.rapidzz.garageapp.Models.DataModels.GeneralModels.User
import com.rapidzz.garageapp.Models.DataModels.UtilityModels.BaseResponse
import java.io.Serializable

data class LoginResponse( val detail: User
): BaseResponse(), Serializable