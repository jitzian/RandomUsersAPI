package com.org.test.randomusersapp.ui.screens.main.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.org.test.randomusersapp.data.db.entities.ResultEntityDB
import com.org.test.randomusersapp.data.db.extensions.idEntityToJson
import com.org.test.randomusersapp.ui.common.RowItem
import com.org.test.randomusersapp.ui.common.ScrollFloatingButton

@Composable
fun MainScreenBuilder(
    modifier: Modifier = Modifier,
    data: List<ResultEntityDB>,
    navigateToDetails: (String) -> Unit,
    onFetchMore: (() -> Unit)? = null,
) {
    val state = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Box(modifier = modifier.fillMaxWidth()) {
        LazyColumn(state = state) {
            items(data) { item ->
                RowItem(
                    data = item
                ) { navigateToDetails(item.idEntityToJson) }
            }
            onFetchMore?.let {
                item {
                    Text(
                        text = "More...",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .clickable { onFetchMore() }
                        ,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
        ScrollFloatingButton(state = state, coroutineScope = coroutineScope, data = data)
    }
}