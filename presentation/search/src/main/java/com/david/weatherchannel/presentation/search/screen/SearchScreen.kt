package com.david.weatherchannel.presentation.search.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.david.weatherchannel.core.resources.R
import com.david.weatherchannel.core.ui.state.RenderContent
import com.david.weatherchannel.presentation.search.component.LocationResultsList
import com.david.weatherchannel.presentation.search.component.MessageContent
import com.david.weatherchannel.presentation.search.model.SearchAction
import com.david.weatherchannel.presentation.search.model.SearchScreenState
import com.david.weatherchannel.presentation.search.preview.SearchScreenStatePreviewProvider
import com.david.weatherchannel.presentation.shared.ui.ErrorContent
import com.david.weatherchannel.presentation.shared.ui.LoadingContent

@Composable
fun SearchScreen(
    state: SearchScreenState,
    onAction: (SearchAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {
        SearchField(
            query = state.query,
            onQueryChange = { onAction(SearchAction.OnQueryChange(it)) },
            onSubmit = { onAction(SearchAction.OnSearchSubmit) },
            modifier = Modifier.fillMaxWidth(),
        )

        state.results.RenderContent(
            idleContent = {
                MessageContent(
                    text = stringResource(R.string.search_idle_message),
                    modifier = Modifier.fillMaxSize(),
                )
            },
            loadingContent = { LoadingContent() },
            errorContent = { message ->
                ErrorContent(message = message, onRetry = { onAction(SearchAction.OnRetryClick) })
            },
            successContent = { locations ->
                if (locations.isEmpty()) {
                    MessageContent(
                        text = stringResource(R.string.search_no_results_message),
                        modifier = Modifier.fillMaxSize(),
                    )
                } else {
                    LocationResultsList(
                        results = locations,
                        onLocationClick = { location -> onAction(SearchAction.OnCitySelected(location)) },
                    )
                }
            },
        )
    }
}

@Composable
private fun SearchField(
    query: String,
    onQueryChange: (String) -> Unit,
    onSubmit: () -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = modifier.padding(bottom = 16.dp),
        label = { Text(text = stringResource(R.string.search_field_label)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = { onSubmit() }),
        trailingIcon = {
            IconButton(onClick = onSubmit) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.action_search),
                )
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun SearchScreenPreview(
    @PreviewParameter(SearchScreenStatePreviewProvider::class) state: SearchScreenState,
) {
    SearchScreen(state = state, onAction = {})
}
