package com.david.weatherchannel.di

import com.david.weatherchannel.core.navigation.EntryProviderInstaller
import com.david.weatherchannel.presentation.search.navigation.searchNavigation
import com.david.weatherchannel.presentation.weather.details.navigation.weatherDetailsNavigation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
object AppNavigationModule {

    @Provides
    @IntoSet
    fun provideSearchEntryProviderInstaller(): EntryProviderInstaller = {
        searchNavigation()
    }

    @Provides
    @IntoSet
    fun provideWeatherDetailsEntryProviderInstaller(): EntryProviderInstaller = {
        weatherDetailsNavigation()
    }
}
