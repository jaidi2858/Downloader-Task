package com.junaid.dowloandingtask.Models.DataModels.ResponceModels


import com.junaid.dowloandingtask.Models.DataModels.GeneralModels.User
import com.junaid.dowloandingtask.Models.DataModels.UtilityModels.BaseResponse
import java.io.Serializable

data class LoginResponse( val detail: User
): BaseResponse(), Serializable