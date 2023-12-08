package com.iznan.model.responsedata

import com.google.gson.annotations.SerializedName

data class CoinInfoResponseData(

    @SerializedName("Name")
    val name: String,

    @SerializedName("FullName")
    val fullName: String

)
