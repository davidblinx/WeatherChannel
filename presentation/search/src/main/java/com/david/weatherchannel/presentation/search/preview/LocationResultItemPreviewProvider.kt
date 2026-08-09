package com.david.weatherchannel.presentation.search.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.david.weatherchannel.presentation.search.model.LocationResultUiModel

class LocationResultItemPreviewProvider : PreviewParameterProvider<LocationResultUiModel> {

    override val values: Sequence<LocationResultUiModel>
        get() = sequenceOf(
            LocationResultUiModel(displayName = "London, GB", latitude = 51.5, longitude = -0.12),
        )
}
