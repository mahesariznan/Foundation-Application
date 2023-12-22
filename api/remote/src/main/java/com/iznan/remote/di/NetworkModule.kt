package com.iznan.remote.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.iznan.remote.api.CryptoCoinService
import com.iznan.remote.datasource.CryptoCoinDataSource
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
    fun provideOkhttpCLient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .connectTimeout(Constants.API_CONNECT_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
            .writeTimeout(Constants.API_WRITE_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
            .readTimeout(Constants.API_READ_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideCryptoCoinService(retrofit: Retrofit): CryptoCoinService {
        return retrofit.create(CryptoCoinService::class.java)
    }

    @Provides
    @Singleton
    fun provideCryptoDataSource(cryptoCoinService: CryptoCoinService): CryptoCoinDataSource {
        return CryptoCoinDataSource(cryptoCoinService)
    }

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "store_preference")

    @Singleton
    @Provides
    fun provideDataStore(
        @ApplicationContext context: Context
    ): DataStore<Preferences> = context.dataStore

}