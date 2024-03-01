package com.org.test.randomusersapp.ui.screens.main.ui

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.org.test.randomusersapp.ui.theme.RandomUsersAppTheme

@Composable
fun LoadMore(
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    onFetchMore: () -> Unit
) {
    val progressValue = 1f
    val infiniteTransition = rememberInfiniteTransition(label = "")

    val progressAnimationValue by infiniteTransition.animateFloat(
        initialValue = 0.0f,
        targetValue = progressValue,
        animationSpec = infiniteRepeatable(
            animation = tween(1000)
        ),
        label = ""
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),

        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "More...",
            modifier = modifier
                //.fillMaxWidth()
                .padding(horizontal = 8.dp)
                .clickable { onFetchMore() },
            textAlign = TextAlign.Center,

        )
        if(isLoading) {
            CircularProgressIndicator(
                progress = progressAnimationValue,
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp),
                strokeWidth = 2.dp,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevLoadMore() = RandomUsersAppTheme {
    LoadMore(
        onFetchMore = { }
    )
}@Preview(showBackground = true)
@Composable
fun PrevLoadMoreShowLoading() = RandomUsersAppTheme {
    LoadMore(
        onFetchMore = { },
        isLoading = true
    )
}