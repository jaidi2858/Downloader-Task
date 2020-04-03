package com.rapidzz.kidcap.Models.DataModels.ResponceModels


import com.rapidzz.kidcap.Models.DataModels.GeneralModels.User
import com.rapidzz.kidcap.Models.DataModels.UtilityModels.BaseResponse
import java.io.Serializable

data class LoginResponse( val data: User
): BaseResponse(), Serializable