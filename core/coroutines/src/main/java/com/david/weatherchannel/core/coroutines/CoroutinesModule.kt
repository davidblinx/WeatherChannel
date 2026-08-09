package com.david.weatherchannel.core.coroutines

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object CoroutinesModule {

    @[Provides IODispatcher]
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @[Provides MainDispatcher]
    fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @[Provides MainImmediateDispatcher]
    fun provideMainImmediateDispatcher(): CoroutineDispatcher = Dispatchers.Main.immediate

    @[Provides DefaultDispatcher]
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @[Provides Singleton ApplicationScope]
    fun provideAppScope(@DefaultDispatcher defaultDispatcher: CoroutineDispatcher): CoroutineScope =
        CoroutineScope(context = SupervisorJob() + defaultDispatcher)
}
