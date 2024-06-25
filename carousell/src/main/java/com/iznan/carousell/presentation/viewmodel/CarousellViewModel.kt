package com.iznan.carousell.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.iznan.domain.base.Resource
import com.iznan.domain.entity.News
import com.iznan.domain.usecase.CarousellUseCase
import com.iznan.foundation.base.BaseViewModel
import com.iznan.foundation.base.CompDispatchers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarousellViewModel @Inject constructor(
    private val carousellUseCase: CarousellUseCase,
    private val dispatchers: CompDispatchers
) : BaseViewModel() {

    private val _newsData: MutableStateFlow<Resource<List<News>?>> =
        MutableStateFlow(Resource.loading())
    val newsData = _newsData.asStateFlow()

    fun sortByPopular() {
        _newsData.value.data?.sortedBy { it.rank }.also { _newsData.value = Resource.success(it) }
    }

    fun sortByRecent() {
        _newsData.value.data?.sortedByDescending { it.timeCreated }
            .also { _newsData.value = Resource.success(it) }
    }

    internal fun getNewsList() = viewModelScope.launch(dispatchers.io) {
        carousellUseCase.getNewsList().collectLatest { resource ->
            _newsData.value = resource.mapResource {
                it?.sortedByDescending { it.timeCreated }
            }
        }
    }

}