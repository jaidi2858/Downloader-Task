package com.rapidzz.kidcap.Models.DataModels.ResponceModels


import com.rapidzz.kidcap.Models.DataModels.GeneralModels.DDItem
import com.rapidzz.kidcap.Models.DataModels.UtilityModels.BaseResponse
import java.io.Serializable

data class ProfessionsResponse(val detail: ArrayList<DDItem>
): BaseResponse(), Serializable