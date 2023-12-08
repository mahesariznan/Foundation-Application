package com.iznan.domain.di

import com.iznan.domain.irepository.ICryptoCoinRepository
import com.iznan.domain.usecase.CryptoCoinUseCase
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

}