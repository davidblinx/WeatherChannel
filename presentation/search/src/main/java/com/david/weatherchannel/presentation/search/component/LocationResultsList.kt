package com.david.weatherchannel.presentation.search.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.david.weatherchannel.presentation.search.model.LocationResultUiModel
import com.david.weatherchannel.presentation.search.preview.LocationResultsListPreviewProvider
import kotlinx.collections.immutable.ImmutableList

@Composable
fun LocationResultsList(
    results: ImmutableList<LocationResultUiModel>,
    onLocationClick: (LocationResultUiModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(results, key = { result -> "${result.latitude}_${result.longitude}" }) { result ->
            LocationResultItem(uiModel = result, onClick = { onLocationClick(result) })
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LocationResultsListPreview(
    @PreviewParameter(LocationResultsListPreviewProvider::class) results: ImmutableList<LocationResultUiModel>,
) {
    LocationResultsList(results = results, onLocationClick = {})
}
