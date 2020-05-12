package com.rapidzz.garageapp.Models.DataModels.ResponceModels


import com.rapidzz.garageapp.Models.DataModels.UtilityModels.BaseResponse
import java.io.Serializable

data class GeneralIntResponse(val result: Int
) : BaseResponse(), Serializable {

}