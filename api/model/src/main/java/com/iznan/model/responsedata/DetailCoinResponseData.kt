package com.iznan.model.responsedata

import com.google.gson.annotations.SerializedName

data class DetailCoinResponseData(

    @SerializedName("DISPLAY")
    val display: DisplayCoinResponseData,

    @SerializedName("CoinInfo")
    val coinInfo: CoinInfoResponseData

)
