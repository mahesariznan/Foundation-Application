package com.iznan.domain.usecase

import com.iznan.domain.irepository.IDataStoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataStoreUseCase @Inject constructor(
    private val dataStoreRepository: IDataStoreRepository
) {

    suspend fun saveCoinName(coinName: String) {
        dataStoreRepository.saveDataCoin(coinName)
    }

    fun getCoinName(): Flow<String> =
        dataStoreRepository.getDataCoin()

}