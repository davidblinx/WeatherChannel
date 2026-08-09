package com.david.weatherchannel.presentation.search.component

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.david.weatherchannel.presentation.search.preview.MessageContentPreviewProvider

@Composable
fun MessageContent(text: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
private fun MessageContentPreview(
    @PreviewParameter(MessageContentPreviewProvider::class) text: String,
) {
    MessageContent(text = text)
}
