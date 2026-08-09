package com.david.weatherchannel.presentation.search.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.david.weatherchannel.core.ui.state.UIState
import com.david.weatherchannel.core.ui.state.UIStateHolder
import com.david.weatherchannel.presentation.search.model.LocationResultUiModel
import com.david.weatherchannel.presentation.search.model.SearchScreenState
import kotlinx.collections.immutable.persistentListOf

class SearchScreenStatePreviewProvider : PreviewParameterProvider<SearchScreenState> {

    override val values: Sequence<SearchScreenState>
        get() = sequenceOf(
            SearchScreenState(),
            SearchScreenState(query = "London", results = UIStateHolder(uiState = UIState.Idle)),
            SearchScreenState(query = "London", results = UIStateHolder(uiState = UIState.Loading)),
            SearchScreenState(
                query = "London",
                results = UIStateHolder(
                    uiState = UIState.Success,
                    payload = persistentListOf(
                        LocationResultUiModel(displayName = "London, GB", latitude = 51.5, longitude = -0.12),
                        LocationResultUiModel(
                            displayName = "London, Ontario, CA",
                            latitude = 42.98,
                            longitude = -81.25,
                        ),
                    ),
                ),
            ),
            SearchScreenState(
                query = "zzzzz",
                results = UIStateHolder(uiState = UIState.Success, payload = persistentListOf()),
            ),
            SearchScreenState(
                query = "London",
                results = UIStateHolder(uiState = UIState.Error(message = "Unable to search for that city")),
            ),
        )
}
