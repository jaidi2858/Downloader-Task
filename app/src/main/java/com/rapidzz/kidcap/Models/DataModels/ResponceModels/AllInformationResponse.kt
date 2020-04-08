package com.rapidzz.kidcap.Models.DataModels.ResponceModels


import com.rapidzz.kidcap.Models.DataModels.GeneralModels.AllUserInfo
import com.rapidzz.kidcap.Models.DataModels.GeneralModels.DDItem
import com.rapidzz.kidcap.Models.DataModels.UtilityModels.BaseResponse
import java.io.Serializable

data class AllInformationResponse(val detail: AllUserInfo
): BaseResponse(), Serializable