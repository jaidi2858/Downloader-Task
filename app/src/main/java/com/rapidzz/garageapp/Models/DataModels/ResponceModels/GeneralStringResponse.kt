package com.rapidzz.garageapp.Models.DataModels.ResponceModels


import com.rapidzz.garageapp.Models.DataModels.UtilityModels.BaseResponse
import java.io.Serializable

data class GeneralStringResponse(var result: String
): BaseResponse(), Serializable {

}