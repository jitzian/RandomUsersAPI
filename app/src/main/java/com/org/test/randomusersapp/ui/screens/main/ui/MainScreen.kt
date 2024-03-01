package com.org.test.randomusersapp.ui.screens.main.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.org.test.randomusersapp.data.db.entities.ResultEntityDB
import com.org.test.randomusersapp.ui.appscreen.UsersAppContent
import com.org.test.randomusersapp.ui.common.MainTopBar
import com.org.test.randomusersapp.ui.common.screens.error.ErrorScreen
import com.org.test.randomusersapp.ui.common.screens.loading.LoadingScreen
import com.org.test.randomusersapp.ui.screens.main.state.MainStateUI
import com.org.test.randomusersapp.ui.screens.main.viewmodels.MainViewModel

@Composable
fun MainState(
    navigateToDetails: (String) -> Unit,
    mainViewModel: MainViewModel = hiltViewModel(),
) {
    val state by mainViewModel.state.collectAsState()
    val page by mainViewModel.page.collectAsState()

    //TODO: Change this..!!
    //mainViewModel.getUsersData(1, 10, "abc")

    when (state) {
        is MainStateUI.Empty -> Unit
        is MainStateUI.Loading -> LoadingScreen()
        is MainStateUI.Success -> {
            MainScreen(
                data = (state as MainStateUI.Success).data,
                navigateToDetails = navigateToDetails,
                onFetchMore = { mainViewModel.getUsersData(page, 10, "abc") },
                isLoading = (state as MainStateUI.Success).isLoading
            )
        }

        is MainStateUI.Error -> {
            ErrorScreen(
                message = (state as MainStateUI.Error).message,
                /**
                 * TODO:
                1. Implement More button
                2. Move page into the state and increment it when more is pressed
                 */
                //onRetryAction = { mainViewModel.getUsersData(1, 10, "abc") }
                onRetryAction = { mainViewModel.getUsersData(page, 10, "abc") }
            )
        }
    }

}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    data: List<ResultEntityDB>,
    navigateToDetails: (String) -> Unit,
    onFetchMore: (() -> Unit)? = null,
    isLoading: Boolean = false,
) {
    UsersAppContent {
        Scaffold(topBar = { MainTopBar(barTitle = "Random Users App") }) {
            MainScreenBuilder(
                data = data,
                navigateToDetails = navigateToDetails,
                modifier = modifier.padding(it),
                onFetchMore = onFetchMore,
                isLoading = isLoading
            )
        }
    }
}