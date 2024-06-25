package com.iznan.domain.irepository

import com.iznan.domain.base.Resource
import com.iznan.model.responsedata.NewsResponseData
import kotlinx.coroutines.flow.Flow

interface INewsRepository {

    fun getNewsList(): Flow<Resource<List<NewsResponseData>>>

}