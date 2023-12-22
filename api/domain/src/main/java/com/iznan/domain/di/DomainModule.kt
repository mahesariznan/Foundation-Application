package com.iznan.domain.di

import com.iznan.domain.irepository.ICryptoCoinRepository
import com.iznan.domain.irepository.IDataStoreRepository
import com.iznan.domain.usecase.CryptoCoinUseCase
import com.iznan.domain.usecase.DataStoreUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    fun provideCryptoCoinUseCase(coinRepository: ICryptoCoinRepository): CryptoCoinUseCase {
        return CryptoCoinUseCase(coinRepository)
    }

    @Provides
    fun provideDataSoreUseCase(dataStoreRepository: IDataStoreRepository): DataStoreUseCase {
        return DataStoreUseCase(dataStoreRepository)
    }

}