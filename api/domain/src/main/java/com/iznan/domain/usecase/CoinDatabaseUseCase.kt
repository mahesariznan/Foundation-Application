package com.iznan.domain.usecase

import com.iznan.domain.entity.Coin
import com.iznan.domain.irepository.ICoinDatabaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CoinDatabaseUseCase @Inject constructor(private val coinDatabaseRepository: ICoinDatabaseRepository) {

    suspend fun insertCoinDatabase(coin: Coin) {
        coinDatabaseRepository.insertCoinData(coin)
    }

    suspend fun getCoinDatabase(): Flow<List<Coin>> = coinDatabaseRepository.getCoinData()

}