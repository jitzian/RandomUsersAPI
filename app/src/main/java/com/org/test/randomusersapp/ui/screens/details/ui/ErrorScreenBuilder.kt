package com.org.test.randomusersapp.ui.screens.details.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.org.test.randomusersapp.R
import com.org.test.randomusersapp.ui.appscreen.UsersAppContent
import com.org.test.randomusersapp.ui.common.MainTopBar
import com.org.test.randomusersapp.ui.common.screens.error.ErrorScreen

@Composable
fun ErrorScreenBuilder(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    message: String,
) {
    UsersAppContent {
        Scaffold(
            topBar = {
                MainTopBar(
                    barTitle = stringResource(id = R.string.details_TEXT),
                    showBackButton = true,
                    onBackClick = onBackClick
                )
            }) { innerPadding ->
            ErrorScreen(message = message, modifier = modifier.padding(innerPadding))
        }
    }
}