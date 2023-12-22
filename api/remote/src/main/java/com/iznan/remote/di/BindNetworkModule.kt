package com.iznan.remote.di

import com.iznan.domain.irepository.ICoinDatabaseRepository
import com.iznan.domain.irepository.ICryptoCoinRepository
import com.iznan.domain.irepository.IDataStoreRepository
import com.iznan.remote.repository.CoinDatabaseRepository
import com.iznan.remote.repository.CryptoCoinRepository
import com.iznan.remote.repository.DataStoreRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class BindNetworkModule {

    @Binds
    abstract fun bindCryptoCoinRepository(cryptoCoinRepository: CryptoCoinRepository): ICryptoCoinRepository

    @Binds
    abstract fun bindDataStoreRepository(dataStoreRepository: DataStoreRepository): IDataStoreRepository

    @Binds
    abstract fun bindCoinDatabaseRepository(coinDatabaseRepository: CoinDatabaseRepository): ICoinDatabaseRepository

}