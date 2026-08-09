package com.david.weatherchannel.presentation.search.component

import androidx.compose.foundation.clickable
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.david.weatherchannel.presentation.search.model.LocationResultUiModel
import com.david.weatherchannel.presentation.search.preview.LocationResultItemPreviewProvider

@Composable
fun LocationResultItem(
    uiModel: LocationResultUiModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    ListItem(
        headlineContent = { Text(text = uiModel.displayName) },
        modifier = modifier.clickable(onClick = onClick),
    )
}

@Preview(showBackground = true)
@Composable
private fun LocationResultItemPreview(
    @PreviewParameter(LocationResultItemPreviewProvider::class) uiModel: LocationResultUiModel,
) {
    LocationResultItem(uiModel = uiModel, onClick = {})
}
