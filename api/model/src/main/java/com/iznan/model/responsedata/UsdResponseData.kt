package com.iznan.model.responsedata

import com.google.gson.annotations.SerializedName

data class UsdResponseData(

    @SerializedName("FROMSYMBOL")
    val fromSymbol: String,

    @SerializedName("PRICE")
    val price: String,

    @SerializedName("OPENDAY")
    val openDay: String,

    @SerializedName("CHANGEDAY")
    val changeDay: String

)
