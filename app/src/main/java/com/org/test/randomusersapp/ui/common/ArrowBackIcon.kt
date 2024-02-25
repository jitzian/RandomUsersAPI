package com.org.test.randomusersapp.ui.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.org.test.randomusersapp.R
import com.org.test.randomusersapp.ui.theme.RandomUsersAppTheme

@Composable
fun ArrowBackIcon(onBackClick: () -> Unit) {
    IconButton(
        onClick = onBackClick,
        modifier = Modifier.testTag(stringResource(id = R.string.arrowBackIcon_iconButton_test_TAG))
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = stringResource(id = R.string.back_TEXT)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PrevArrowBackIconLightMode() = RandomUsersAppTheme { ArrowBackIcon(onBackClick = { }) }

