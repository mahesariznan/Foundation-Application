package com.iznan.remote.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Room
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.iznan.remote.api.CryptoCoinService
import com.iznan.remote.dao.CoinDao
import com.iznan.remote.datasource.CryptoCoinDataSource
import com.iznan.remote.datasource.RoomDatabaseDataSource
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

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): RoomDatabaseDataSource {
        return Room
            .databaseBuilder(context, RoomDatabaseDataSource::class.java, "foundation_database.db")
            .build()
    }

    @Singleton
    @Provides
    fun provideCoinDao(roomDatabaseDataSource: RoomDatabaseDataSource): CoinDao {
        return roomDatabaseDataSource.coinDao()
    }

}