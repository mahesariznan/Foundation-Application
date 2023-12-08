package com.iznan.domain.usecase

import com.iznan.domain.base.Resource
import com.iznan.domain.entity.Coin
import com.iznan.domain.irepository.ICryptoCoinRepository
import com.iznan.domain.mapper.CoinListMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CryptoCoinUseCase @Inject constructor(private val coinRepository: ICryptoCoinRepository) {

    fun getCoinList(page: Int): Flow<Resource<List<Coin>?>> {
        return coinRepository.getCoinList(page = page).map { resource ->
            resource.mapResource {
                CoinListMapper().mapToListEntity(it)
            }
        }
    }

}