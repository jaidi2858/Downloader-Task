package com.rapidzz.kidcap.Models.DataModels.UtilityModels

import java.io.Serializable

open class BaseResponse(val code: Int = 0,
                        var message: String = "") : Serializable {

}