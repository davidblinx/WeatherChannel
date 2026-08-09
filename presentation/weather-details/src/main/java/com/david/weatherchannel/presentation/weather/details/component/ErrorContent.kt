package com.david.weatherchannel.presentation.weather.details.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.david.weatherchannel.presentation.weather.details.preview.ErrorContentPreviewProvider

@Composable
fun ErrorContent(message: String?, onRetry: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(text = message ?: "Something went wrong")
        TextButton(onClick = onRetry) { Text(text = "Retry") }
    }
}

@Preview(showBackground = true)
@Composable
private fun ErrorContentPreview(
    @PreviewParameter(ErrorContentPreviewProvider::class) message: String?,
) {
    ErrorContent(message = message, onRetry = {})
}
