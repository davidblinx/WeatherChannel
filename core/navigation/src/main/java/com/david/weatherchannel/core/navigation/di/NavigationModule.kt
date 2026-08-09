package com.david.weatherchannel.core.navigation.di

import com.david.weatherchannel.core.navigation.Navigator
import com.david.weatherchannel.core.navigation.NavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class NavigationModule {

    @Binds
    abstract fun bindNavigator(impl: NavigatorImpl): Navigator
}
