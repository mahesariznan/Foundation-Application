package com.iznan.remote.api

import com.iznan.model.responsedata.NewsResponseData
import retrofit2.Response
import retrofit2.http.GET

interface NewsService {

    @GET("/carousell-interview-assets/android/carousell_news.json")
    suspend fun getNewsCoin(): Response<List<NewsResponseData>>

}