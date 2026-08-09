package com.david.weatherchannel.presentation.shared.ui.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class ErrorContentPreviewProvider : PreviewParameterProvider<String?> {

    override val values: Sequence<String?>
        get() = sequenceOf(
            "Something went wrong",
            null,
        )
}
