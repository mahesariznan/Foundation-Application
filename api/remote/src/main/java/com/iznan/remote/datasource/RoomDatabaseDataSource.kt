package com.iznan.remote.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.iznan.domain.entity.Coin
import com.iznan.remote.dao.CoinDao

@Database(entities = [Coin::class], version = 1, exportSchema = true)
abstract class RoomDatabaseDataSource : RoomDatabase() {

    abstract fun coinDao(): CoinDao

}