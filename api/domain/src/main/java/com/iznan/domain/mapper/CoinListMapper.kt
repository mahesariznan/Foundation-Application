package com.iznan.domain.mapper

import com.iznan.domain.base.BaseMapper
import com.iznan.domain.entity.Coin
import com.iznan.model.responsedata.DetailCoinResponseData

class CoinListMapper : BaseMapper<DetailCoinResponseData, Coin> {

    override fun mapToEntity(model: DetailCoinResponseData): Coin {
        return Coin(
            name = model.coinInfo.name,
            fullName = model.coinInfo.fullName,
            symbol = model.display.usd.fromSymbol,
            price = model.display.usd.price,
            open = model.display.usd.openDay,
            changeDay = model.display.usd.changeDay
        )
    }

    fun mapToListEntity(models: List<DetailCoinResponseData>?): List<Coin>? {
        return if (models != null) {
            val result = mutableListOf<Coin>()
            models.forEach {
                result.add(mapToEntity(it))
            }
            result
        } else null
    }

}