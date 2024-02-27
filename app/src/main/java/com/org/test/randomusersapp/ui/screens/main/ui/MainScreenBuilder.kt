package com.org.test.randomusersapp.ui.screens.main.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.org.test.randomusersapp.data.db.entities.ResultEntityDB
import com.org.test.randomusersapp.data.db.extensions.idEntityToJson
import com.org.test.randomusersapp.ui.common.RowItem

@Composable
fun MainScreenBuilder(
    modifier: Modifier = Modifier,
    data: List<ResultEntityDB>,
    navigateToDetails: (String) -> Unit,
) {
    val state = rememberLazyListState()
    Box(modifier = modifier.fillMaxWidth()) {
        LazyColumn(state = state) {
            items(data) { item ->
                RowItem(
                    data = item
                ) { navigateToDetails(item.idEntityToJson) }
            }
        }
    }
}