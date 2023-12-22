package com.iznan.remote.repository

import com.iznan.domain.entity.Coin
import com.iznan.domain.irepository.ICoinDatabaseRepository
import com.iznan.remote.dao.CoinDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CoinDatabaseRepository @Inject constructor(private val coinDao: CoinDao) :
    ICoinDatabaseRepository {

    override suspend fun insertCoinData(data: Coin) {
        coinDao.insertCoinData(data)
    }

    override suspend fun getCoinData(): Flow<List<Coin>> = coinDao.getAllCoinData()
}