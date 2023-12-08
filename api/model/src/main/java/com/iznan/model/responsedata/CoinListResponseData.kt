package com.iznan.model.responsedata

import com.google.gson.annotations.SerializedName
import com.iznan.model.base.BaseResponseData

data class CoinListResponseData(

    @SerializedName("Message")
    override val message: String = "",

    @SerializedName("Data")
    val detailCoin: List<DetailCoinResponseData> = listOf()

) : BaseResponseData
