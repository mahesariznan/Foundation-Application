package com.iznan.remote.repository

import com.iznan.domain.base.Resource
import com.iznan.domain.irepository.INewsRepository
import com.iznan.model.responsedata.NewsResponseData
import com.iznan.remote.datasource.NewsDataSource
import com.iznan.remote.handler.networkHandling
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsDataSource: NewsDataSource) :
    INewsRepository {

    override fun getNewsList(): Flow<Resource<List<NewsResponseData>>> {
        return networkHandling(
            callApi = { newsDataSource.getNewsList() },
            processResult = { it }
        )
    }

}