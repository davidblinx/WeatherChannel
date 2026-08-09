package com.david.weatherchannel.core.coroutines

import javax.inject.Qualifier

@Qualifier
@Retention
annotation class DefaultDispatcher

@Qualifier
@Retention
annotation class IODispatcher

@Qualifier
@Retention
annotation class MainDispatcher

@Qualifier
@Retention
annotation class MainImmediateDispatcher
