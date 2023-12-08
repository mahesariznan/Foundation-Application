package com.iznan.remote.di

import com.iznan.domain.irepository.ICryptoCoinRepository
import com.iznan.remote.repository.CryptoCoinRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class BindNetworkModule {

    @Binds
    abstract fun bindCryptoCoinRepository(cryptoCoinRepository: CryptoCoinRepository): ICryptoCoinRepository

}