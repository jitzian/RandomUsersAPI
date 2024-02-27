package com.org.test.randomusersapp.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.org.test.randomusersapp.R
import com.org.test.randomusersapp.ui.theme.RandomUsersAppTheme

@Composable
fun ProductImage(
    url: String,
    name: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray)
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = url),
            contentDescription = name,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = dimensionResource(id = R.dimen.dimen_6_dp))
                .aspectRatio(1f)
                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dimen_4_dp)))
        )
    }
}

@Preview
@Composable
fun PevProductImage() =
    RandomUsersAppTheme {
        ProductImage(
            url = "https://somethwre.com/image.jpg",
            name = "A name"
        )
    }
