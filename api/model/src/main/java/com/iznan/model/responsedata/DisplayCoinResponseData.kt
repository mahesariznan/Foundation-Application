package com.iznan.model.responsedata

import com.google.gson.annotations.SerializedName

data class DisplayCoinResponseData(

    @SerializedName("USD")
    val usd: UsdResponseData

)
