package com.iznan.model.responsedata

import com.iznan.model.base.BaseResponseData

data class NewsResponseData(
    val title: String,
    val description: String,
    val banner_url: String,
    val time_created: Long,
    val rank: Int
) : BaseResponseData

