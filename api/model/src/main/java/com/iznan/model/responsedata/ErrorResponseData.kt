package com.iznan.model.responsedata

import com.google.gson.annotations.SerializedName

data class ErrorResponseData(

    @SerializedName("Response")
    val response: String,

    @SerializedName("Message")
    val message: String

)
