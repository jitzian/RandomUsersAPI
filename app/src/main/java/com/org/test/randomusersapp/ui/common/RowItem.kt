package com.org.test.randomusersapp.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.org.test.randomusersapp.R
import com.org.test.randomusersapp.data.db.entities.ResultEntityDB
import com.org.test.randomusersapp.ui.utils.mockedDobEntityDB
import com.org.test.randomusersapp.ui.utils.mockedIdEntityDB
import com.org.test.randomusersapp.ui.utils.mockedLocationEntityDB
import com.org.test.randomusersapp.ui.utils.mockedLoginEntityDB
import com.org.test.randomusersapp.ui.utils.mockedNameEntityDB
import com.org.test.randomusersapp.ui.utils.mockedPictureEntityDB
import com.org.test.randomusersapp.ui.utils.mockedRegisteredEntityDB

@Composable
fun RowItem(
    data: ResultEntityDB,
    onItemClick: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .semantics(mergeDescendants = true) {}
            .padding(
                horizontal = dimensionResource(id = R.dimen.dimen_16_dp),
                vertical = dimensionResource(id = R.dimen.dimen_8_dp)
            )
            .clickable {
                onItemClick.invoke(data.id)
            },

        ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = dimensionResource(id = R.dimen.dimen_8_dp),
                    top = dimensionResource(id = R.dimen.dimen_24_dp),
                    end = dimensionResource(id = R.dimen.dimen_8_dp)
                )
                .clickable { onItemClick.invoke(data.id) }
        ) {
            ProductImage(name = data.nameEntityDB.first, url = data.pictureEntityDB.large)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(id = R.dimen.dimen_8_dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = data.nameEntityDB.title,
                    style = MaterialTheme.typography.bodySmall,
                )
                Spacer(modifier = Modifier.weight(1f))
            }
            Text(
                text = data.nameEntityDB.first,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = dimensionResource(id = R.dimen.dimen_8_dp)),
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PrevRowItemFav() =
    RowItem(
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
        )
    ) { }

