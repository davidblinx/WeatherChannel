package com.david.weatherchannel.presentation.weather.details.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class ErrorContentPreviewProvider : PreviewParameterProvider<String?> {

    override val values: Sequence<String?>
        get() = sequenceOf(
            "Unable to load weather",
            null,
        )
}
