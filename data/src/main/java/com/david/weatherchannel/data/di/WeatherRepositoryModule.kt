package com.david.weatherchannel.data.di

import com.david.weatherchannel.data.repository.WeatherRepositoryImpl
import com.david.weatherchannel.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class WeatherRepositoryModule {

    @Binds
    abstract fun bindWeatherRepository(impl: WeatherRepositoryImpl): WeatherRepository
}