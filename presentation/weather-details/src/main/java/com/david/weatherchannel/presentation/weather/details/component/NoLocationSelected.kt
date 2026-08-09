package com.david.weatherchannel.presentation.weather.details.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NoLocationSelected(onSearchClick: () -> Unit, modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(text = "Select a city to see its weather")
            Button(onClick = onSearchClick) { Text(text = "Search") }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NoLocationSelectedPreview() {
    NoLocationSelected(onSearchClick = {})
}
