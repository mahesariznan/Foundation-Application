package com.iznan.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coin_table")
data class Coin(
    @PrimaryKey
    val name: String,
    val fullName: String,
    val symbol: String,
    val price: String,
    val open: String,
    val changeDay: String
)