package com.org.test.randomusersapp.ui.screens.details.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.org.test.randomusersapp.data.db.entities.ResultEntityDB
import com.org.test.randomusersapp.ui.appscreen.UsersAppContent
import com.org.test.randomusersapp.ui.common.LoadingScreen
import com.org.test.randomusersapp.ui.common.MainTopBar
import com.org.test.randomusersapp.ui.screens.details.state.DetailsStateUI
import com.org.test.randomusersapp.ui.screens.details.viewmodels.DetailsViewModel
import com.org.test.randomusersapp.ui.theme.RandomUsersAppTheme
import com.org.test.randomusersapp.ui.utils.mockedDobEntityDB
import com.org.test.randomusersapp.ui.utils.mockedIdEntityDB
import com.org.test.randomusersapp.ui.utils.mockedLocationEntityDB
import com.org.test.randomusersapp.ui.utils.mockedLoginEntityDB
import com.org.test.randomusersapp.ui.utils.mockedNameEntityDB
import com.org.test.randomusersapp.ui.utils.mockedPictureEntityDB
import com.org.test.randomusersapp.ui.utils.mockedRegisteredEntityDB

@Composable
fun DetailsScreenState(
    id: String,
    onBackClick: () -> Unit,
    detailsViewModel: DetailsViewModel = hiltViewModel()
) {
    val state by detailsViewModel.state.collectAsState()
    detailsViewModel.getDetailData(id)

    when (state) {
        DetailsStateUI.Empty -> Unit
        /*is DetailsStateUI.Error -> ErrorScreen(
            message = (state as DetailsStateUI.Error).message,
        )*/
        is DetailsStateUI.Error -> ErrorScreenBuilder(
            message = (state as DetailsStateUI.Error).message,
            onBackClick = onBackClick,
        )

        DetailsStateUI.Loading -> LoadingScreen()
        is DetailsStateUI.Success -> DetailsScreen(
            data = (state as DetailsStateUI.Success).data,
            onBackClick = onBackClick
        )
    }
}

@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    data: ResultEntityDB,
    onBackClick: () -> Unit
) {
    UsersAppContent {
        Scaffold(
            topBar = {
                MainTopBar(
                    barTitle = "Details",
                    showBackButton = true,
                    onBackClick = onBackClick
                )
            }) { innerPadding ->
            DetailScreenBuilder(
                data = data,
                modifier = modifier.padding(innerPadding),
            )
        }
    }

}

@Preview
@Composable
fun PrevDetailsScreen() = RandomUsersAppTheme {
    DetailsScreen(
        data = ResultEntityDB(
            cell = "cell",
            dobEntityDB = mockedDobEntityDB,
            email = "email",
            gender = "",
            idEntityDB = mockedIdEntityDB,
            locationEntityDB = mockedLocationEntityDB,
            loginEntityDB = mockedLoginEntityDB,
            nameEntityDB = mockedNameEntityDB,
            nat = "nat",
            phone = "phone",
            pictureEntityDB = mockedPictureEntityDB,
            registered = mockedRegisteredEntityDB,
        ),
        onBackClick = { }
    )
}