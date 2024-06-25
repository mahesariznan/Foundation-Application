package com.iznan.navigator.di

import com.iznan.carousell.navigation.IFeatureOneNavigation
import com.iznan.navigator.navigation.FeatureOneNavigation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindNavigationModule {

    @Singleton
    @Binds
    abstract fun bindFeatureOneNavigation(featureOneNavigation: FeatureOneNavigation): IFeatureOneNavigation

}