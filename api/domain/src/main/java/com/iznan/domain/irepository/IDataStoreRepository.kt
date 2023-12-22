package com.iznan.domain.irepository

import kotlinx.coroutines.flow.Flow

interface IDataStoreRepository {

    suspend fun saveDataCoin(coinName: String)

    fun getDataCoin(): Flow<String>

}