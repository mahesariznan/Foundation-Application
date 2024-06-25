package com.iznan.remote.datasource

import com.iznan.model.responsedata.NewsResponseData
import com.iznan.remote.api.NewsService
import retrofit2.Response
import javax.inject.Inject

class NewsDataSource @Inject constructor(val newsService: NewsService) {

    suspend fun getNewsList(): Response<List<NewsResponseData>> {
        return newsService.getNewsCoin()
    }

}