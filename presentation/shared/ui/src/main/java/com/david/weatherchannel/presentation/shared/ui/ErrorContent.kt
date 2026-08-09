package com.david.weatherchannel.presentation.shared.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.david.weatherchannel.core.resources.R
import com.david.weatherchannel.presentation.shared.ui.preview.ErrorContentPreviewProvider

@Composable
fun ErrorContent(message: String?, onRetry: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(text = message ?: stringResource(R.string.error_generic_message))
        TextButton(onClick = onRetry) { Text(text = stringResource(R.string.retry)) }
    }
}

@Preview(showBackground = true)
@Composable
private fun ErrorContentPreview(
    @PreviewParameter(ErrorContentPreviewProvider::class) message: String?,
) {
    ErrorContent(message = message, onRetry = {})
}
