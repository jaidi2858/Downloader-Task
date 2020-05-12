package com.rapidzz.garageapp.Models.DataModels.ResponceModels


import com.rapidzz.garageapp.Models.DataModels.GeneralModels.AllUserInfo
import com.rapidzz.garageapp.Models.DataModels.UtilityModels.BaseResponse
import java.io.Serializable

data class AllInformationResponse(val detail: AllUserInfo
): BaseResponse(), Serializable