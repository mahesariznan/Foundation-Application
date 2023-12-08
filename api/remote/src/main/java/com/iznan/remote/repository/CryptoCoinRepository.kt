package com.iznan.remote.repository

import com.iznan.domain.base.Resource
import com.iznan.domain.irepository.ICryptoCoinRepository
import com.iznan.model.responsedata.DetailCoinResponseData
import com.iznan.remote.datasource.CryptoCoinDataSource
import com.iznan.remote.handler.networkHandling
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CryptoCoinRepository @Inject constructor(private val cryptoCoinDataSource: CryptoCoinDataSource) :
    ICryptoCoinRepository {

    override fun getCoinList(page: Int): Flow<Resource<List<DetailCoinResponseData>>> {
        return networkHandling(
            callApi = { cryptoCoinDataSource.getCoinList(page) },
            processResult = { it?.detailCoin }
        )
    }

}