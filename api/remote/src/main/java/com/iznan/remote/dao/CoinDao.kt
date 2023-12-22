package com.iznan.remote.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.iznan.domain.entity.Coin
import kotlinx.coroutines.flow.Flow

@Dao
interface CoinDao {

    @Query("SELECT * FROM coin_table")
    fun getAllCoinData(): Flow<List<Coin>>

    @Query("SELECT * FROM coin_table WHERE name = :name")
    fun getCoinData(name: String): Flow<Coin>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCoinData(data: Coin)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateCoinData(data: Coin)

    @Delete
    fun deleteCoinData(data: Coin)

}