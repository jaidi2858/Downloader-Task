package com.junaid.dowloandingtask.Models.DataModels.ResponceModels


import com.junaid.dowloandingtask.Models.DataModels.UtilityModels.BaseResponse
import java.io.Serializable

data class GeneralStringResponse(var result: String
): BaseResponse(), Serializable {

}