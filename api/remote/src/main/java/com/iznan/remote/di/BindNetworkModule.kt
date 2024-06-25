package com.iznan.remote.di

import com.iznan.domain.irepository.INewsRepository
import com.iznan.remote.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class BindNetworkModule {

    @Binds
    abstract fun bindNewsRepository(newsRepository: NewsRepository): INewsRepository


}