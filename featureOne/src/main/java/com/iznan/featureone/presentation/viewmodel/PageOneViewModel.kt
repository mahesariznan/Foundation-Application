package com.iznan.featureone.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.iznan.domain.base.Resource
import com.iznan.domain.usecase.CryptoCoinUseCase
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
    private val dispatchers: CompDispatchers
) : BaseViewModel() {

//    private val _dataApi = MutableLiveData<String>()
//    val dataApi = _dataApi

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
                    _dataApi.value = ("data api: ${resource.data?.firstOrNull()?.symbol}")
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

}