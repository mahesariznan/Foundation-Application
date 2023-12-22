package com.iznan.domain.irepository

import com.iznan.domain.entity.Coin
import kotlinx.coroutines.flow.Flow

interface ICoinDatabaseRepository {

    suspend fun insertCoinData(data: Coin)

    suspend fun getCoinData(): Flow<List<Coin>>

}