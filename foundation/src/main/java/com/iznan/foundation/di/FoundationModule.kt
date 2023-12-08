package com.iznan.foundation.di

import com.iznan.foundation.base.CompDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FoundationModule {

    @Provides
    @Singleton
    fun provideCompDispatcher(): CompDispatchers {
        return CompDispatchers(
            default = Dispatchers.Default,
            io = Dispatchers.IO,
            main = Dispatchers.Main
        )
    }

}