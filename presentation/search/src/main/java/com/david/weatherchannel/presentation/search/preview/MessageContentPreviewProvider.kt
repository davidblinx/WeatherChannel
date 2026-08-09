package com.david.weatherchannel.presentation.search.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class MessageContentPreviewProvider : PreviewParameterProvider<String> {

    override val values: Sequence<String>
        get() = sequenceOf(
            "Search for a city to see its weather",
            "No matching cities found",
        )
}
