package com.iznan.remote.datasource

import com.iznan.model.responsedata.CoinListResponseData
import com.iznan.remote.api.CryptoCoinService
import retrofit2.Response
import javax.inject.Inject

class CryptoCoinDataSource @Inject constructor(val cryptoCoinService: CryptoCoinService) {

    suspend fun getCoinList(page: Int): Response<CoinListResponseData> {
        return cryptoCoinService.getListCoin(page)
    }

}