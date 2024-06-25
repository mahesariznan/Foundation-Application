package com.iznan.remote.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.iznan.remote.api.NewsService
import com.iznan.remote.datasource.NewsDataSource
import com.iznan.remote.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideOkhttpCLient(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient().newBuilder()
            .connectTimeout(Constants.API_CONNECT_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
            .writeTimeout(Constants.API_WRITE_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
            .readTimeout(Constants.API_READ_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
            .addInterceptor(ChuckerInterceptor(context))
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsService(retrofit: Retrofit): NewsService {
        return retrofit.create(NewsService::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsDataSource(newsService: NewsService): NewsDataSource {
        return NewsDataSource(newsService)
    }

}