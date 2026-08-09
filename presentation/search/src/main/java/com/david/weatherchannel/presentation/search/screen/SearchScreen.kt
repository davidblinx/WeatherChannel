package com.david.weatherchannel.presentation.search.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.david.weatherchannel.presentation.search.model.SearchAction
import com.david.weatherchannel.presentation.search.model.SearchScreenState

@Composable
fun SearchScreen(
    state: SearchScreenState,
    onAction: (SearchAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Button(onClick = { onAction(SearchAction.OnCitySelected(lat = 51.5074, lon = -0.1278)) }) {
            Text(text = "Select city")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchScreenPreview() {
    SearchScreen(
        state = SearchScreenState,
        onAction = {},
    )
}
