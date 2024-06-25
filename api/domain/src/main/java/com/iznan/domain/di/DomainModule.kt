package com.iznan.domain.di

import com.iznan.domain.irepository.INewsRepository
import com.iznan.domain.usecase.CarousellUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    fun provideCarousellUseCase(newsRepository: INewsRepository): CarousellUseCase {
        return CarousellUseCase(newsRepository)
    }

}