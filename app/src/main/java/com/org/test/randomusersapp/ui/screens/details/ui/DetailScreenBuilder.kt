package com.org.test.randomusersapp.ui.screens.details.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.org.test.randomusersapp.data.db.entities.ResultEntityDB
import com.org.test.randomusersapp.ui.common.UserImage

@Composable
fun DetailScreenBuilder(
    modifier: Modifier = Modifier,
    data: ResultEntityDB,
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
    ) {
        val (image, label, name, city, email) = createRefs()

        UserImage(
            url = data.pictureEntityDB.medium,
            name = data.nameEntityDB.first,
            modifier = Modifier
                .constrainAs(image) {
                    start.linkTo(parent.start, 16.dp)
                    top.linkTo(parent.top, 16.dp)
                }
                .width(120.dp)
                .height(120.dp)
        )

        Text(
            text = "Label:", //TODO: Move this to string resource
            modifier = Modifier.constrainAs(label) {
                top.linkTo(image.top)
                start.linkTo(image.end, margin = 8.dp)
            },
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold
            ),
        )

        Text(
            text = "${data.nameEntityDB.first} ${data.nameEntityDB.last}",
            modifier = Modifier.constrainAs(name) {
                start.linkTo(label.end, margin = 8.dp)
                top.linkTo(label.top)
                end.linkTo(parent.end, margin = 16.dp)
                bottom.linkTo(label.bottom)
                width = Dimension.fillToConstraints
            },
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = "${data.locationEntityDB.city}, ${data.locationEntityDB.state}",
            modifier = Modifier.constrainAs(city) {
                start.linkTo(label.start)
                top.linkTo(label.bottom, 8.dp)
                end.linkTo(name.end)
                width = Dimension.fillToConstraints
            },
            style = MaterialTheme.typography.bodySmall
        )

        Text(
            text = data.email,
            modifier = Modifier.constrainAs(email) {
                start.linkTo(label.start)
                top.linkTo(city.bottom, 8.dp)
                end.linkTo(name.end)
                width = Dimension.fillToConstraints
            },
            style = MaterialTheme.typography.bodySmall
        )
    }
}