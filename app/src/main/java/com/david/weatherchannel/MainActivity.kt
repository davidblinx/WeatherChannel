package com.david.weatherchannel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.david.weatherchannel.core.navigation.EntryProviderInstaller
import com.david.weatherchannel.core.navigation.NavBackStackActions
import com.david.weatherchannel.core.navigation.Navigator
import com.david.weatherchannel.core.navigation.WeatherDetailsDestination
import com.david.weatherchannel.ui.theme.WeatherChannelTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var entryProviderInstallers: Set<@JvmSuppressWildcards EntryProviderInstaller>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherChannelTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val backStack = rememberNavBackStack(WeatherDetailsDestination())
                    NavBackStackActions(navigator = navigator, backStack = backStack)

                    NavDisplay(
                        backStack = backStack,
                        modifier = Modifier.padding(innerPadding),
                        entryProvider = entryProvider {
                            entryProviderInstallers.forEach { install -> install() }
                        },
                    )
                }
            }
        }
    }
}
