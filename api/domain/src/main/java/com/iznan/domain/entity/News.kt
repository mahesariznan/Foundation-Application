package com.iznan.domain.entity

data class News(
    val title: String,
    val description: String,
    val bannerUrl: String,
    val timeCreated: Long,
    val rank: Int
)