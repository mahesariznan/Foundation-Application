package com.iznan.remote.api

import com.iznan.model.responsedata.CoinListResponseData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoCoinService {

    @GET("/data/top/totaltoptiervolfull?tsym=USD&limit=10&")
    suspend fun getListCoin(@Query("page") page: Int): Response<CoinListResponseData>

}