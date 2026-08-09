package com.david.weatherchannel.presentation.search.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.david.weatherchannel.presentation.search.model.LocationResultUiModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

class LocationResultsListPreviewProvider : PreviewParameterProvider<ImmutableList<LocationResultUiModel>> {

    override val values: Sequence<ImmutableList<LocationResultUiModel>>
        get() = sequenceOf(
            persistentListOf(
                LocationResultUiModel(displayName = "London, GB", latitude = 51.5, longitude = -0.12),
                LocationResultUiModel(displayName = "London, Ontario, CA", latitude = 42.98, longitude = -81.25),
                LocationResultUiModel(displayName = "New London, CT, US", latitude = 41.36, longitude = -72.1),
            ),
        )
}
