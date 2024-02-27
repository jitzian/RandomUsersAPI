package com.org.test.randomusersapp.ui.appscreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.org.test.randomusersapp.ui.theme.RandomUsersAppTheme

@Composable
fun UsersAppContent(content: @Composable () -> Unit) {
    RandomUsersAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) { content() }
    }
}