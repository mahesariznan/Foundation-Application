package com.iznan.navigator.di

import com.iznan.navigator.NavControllerBinder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    @Singleton
    @Provides
    fun provideNavControllerBinder(): NavControllerBinder {
        return NavControllerBinder()
    }

}