package com.rapidzz.kidcap.Models.DataModels.ResponceModels


import com.rapidzz.kidcap.Models.DataModels.UtilityModels.BaseResponse
import java.io.Serializable

data class GeneralStringResponse(var result: String
): BaseResponse(), Serializable {

}