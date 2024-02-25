package com.org.test.randomusersapp.ui.common

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.org.test.randomusersapp.ui.theme.RandomUsersAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
    showBackButton: Boolean = false,
    barTitle: String? = null,
    onBackClick: (() -> Unit)? = null
) {
    if (showBackButton && onBackClick != null) {
        TopAppBar(
            title = { Text(text = barTitle?.takeIf { it.isNotEmpty() } ?: "") },
            navigationIcon = { ArrowBackIcon(onBackClick = onBackClick) }
        )
    } else {
        TopAppBar(title = { Text(text = barTitle?.takeIf { it.isNotEmpty() } ?: "") })
    }
}


@Composable
@Preview(showBackground = true)
fun PrevMainTopBarShowBackButton() = RandomUsersAppTheme {
    MainTopBar(
        showBackButton = true,
        barTitle = "Title",
        onBackClick = {}
    )
}
