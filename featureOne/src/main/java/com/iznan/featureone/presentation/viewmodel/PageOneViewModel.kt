package com.iznan.featureone.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.iznan.domain.base.Resource
import com.iznan.domain.entity.Coin
import com.iznan.domain.usecase.CoinDatabaseUseCase
import com.iznan.domain.usecase.CryptoCoinUseCase
import com.iznan.domain.usecase.DataStoreUseCase
import com.iznan.featureone.navigation.IFeatureOneNavigation
import com.iznan.foundation.base.BaseViewModel
import com.iznan.foundation.base.CompDispatchers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PageOneViewModel @Inject constructor(
    private val nav: IFeatureOneNavigation,
    private val cryptoCoinUseCase: CryptoCoinUseCase,
    private val dataStoreUseCase: DataStoreUseCase,
    private val coinDatabaseUseCase: CoinDatabaseUseCase,
    private val dispatchers: CompDispatchers
) : BaseViewModel() {

    private val _dataRoom = MutableLiveData<List<Coin>>()
    val dataRoom = _dataRoom

    private val _dataApi = MutableStateFlow("")
    val dataApi = _dataApi.asStateFlow()

    internal fun goToOtherModule() {
        nav.navigateToOtherModule("extra data from page 1")
    }

    internal fun goToOtherModuleDifferentStart() {
        nav.navigateToOtherModuleDifferentStart("extra data from page 1")
    }

    internal fun getCoinList() = viewModelScope.launch(dispatchers.io) {
        cryptoCoinUseCase.getCoinList(1).collectLatest { resource ->
            when (resource.status) {
                Resource.Status.SUCCESS -> {
                    Log.e("IZN", "IZN, SUCCESS: ${resource}")
                    resource.data?.firstOrNull()?.apply {
                        insertCoinDatabase(this)
                        saveCoinName(symbol)
                        _dataApi.value = ("data api: $symbol")
                    }
                }

                Resource.Status.ERROR -> {
                    Log.e("IZN", "IZN ERROR: ${resource}")
                }

                Resource.Status.LOADING -> {
                    Log.e("IZN", "IZN LOADING: ${resource}")
                }
            }
        }
    }

    internal fun saveCoinName(coinName: String) = viewModelScope.launch(dispatchers.io) {
        dataStoreUseCase.saveCoinName(coinName)
    }

    internal fun getLastCoinName() = viewModelScope.launch(dispatchers.io) {
        dataStoreUseCase.getCoinName().collectLatest {
            _dataApi.value = ("last data api: $it")
        }
    }

    internal fun insertCoinDatabase(coin: Coin) = viewModelScope.launch(dispatchers.io) {
        coinDatabaseUseCase.insertCoinDatabase(coin)
    }

    internal fun getCoinDatabase() = viewModelScope.launch(dispatchers.io) {
        coinDatabaseUseCase.getCoinDatabase().collectLatest {
            _dataRoom.postValue(it)
        }
    }

}