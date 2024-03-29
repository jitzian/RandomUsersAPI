package com.org.test.randomusersapp.ui.common.screens.error

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.org.test.randomusersapp.R
import com.org.test.randomusersapp.ui.theme.RandomUsersAppTheme

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    errorCode: String? = null,
    message: String,
    onRetryAction: (() -> Unit)? = null
) {

    Column(modifier = modifier.fillMaxSize()) {
        errorCode?.let {
            Text(
                text = it,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold,
            )
        }
        Text(
            text = message,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 32.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
        )
        Image(
            painter = painterResource(id = R.drawable.sad_boy_error),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 32.dp,
                    vertical = 32.dp
                )
        )
        onRetryAction?.let {
            Text(
                text = "Refresh?",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { it.invoke() },
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PrevErrorScreen() = RandomUsersAppTheme {
    ErrorScreen(
        message = "An error occurred while fetching data",
        onRetryAction = { }
    )
}