package com.rapidzz.garageapp.Models.DataModels.ResponceModels


import com.rapidzz.garageapp.Models.DataModels.GeneralModels.DDItem
import com.rapidzz.garageapp.Models.DataModels.UtilityModels.BaseResponse
import java.io.Serializable

data class QualificationsResponse(val detail: ArrayList<DDItem>
): BaseResponse(), Serializable