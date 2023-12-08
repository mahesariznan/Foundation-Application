package com.iznan.domain.irepository

import com.iznan.domain.base.Resource
import com.iznan.model.responsedata.DetailCoinResponseData
import kotlinx.coroutines.flow.Flow

interface ICryptoCoinRepository {

    fun getCoinList(page: Int): Flow<Resource<List<DetailCoinResponseData>>>

}