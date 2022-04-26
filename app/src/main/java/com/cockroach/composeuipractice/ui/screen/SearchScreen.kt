package com.cockroach.composeuipractice.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.cockroach.composeuipractice.R
import com.cockroach.composeuipractice.data.allGenresList
import com.cockroach.composeuipractice.data.topGenresList
import com.cockroach.composeuipractice.ui.compose.SearchBox
import com.cockroach.composeuipractice.ui.compose.SearchItem

@Composable
fun SearchScreen() {
    val configuration = LocalConfiguration.current
    val screenDensity = configuration.densityDpi / 160f
    val screenWidth = configuration.screenWidthDp.dp.value * screenDensity
    val context = LocalContext.current

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        item { Spacer(modifier = Modifier.height(32.dp)) }

        item {
            Text(
                text = stringResource(id = R.string.title_search),
                color = Color.White,
                fontSize = MaterialTheme.typography.h5.fontSize,
                fontWeight = FontWeight.Bold,
            )
        }

        item {
            SearchBox(onSearch = {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            })
        }

        item {
            Text(text = stringResource(id = R.string.top_genres), color = Color.White, style = MaterialTheme.typography.subtitle1)
            Spacer(Modifier.height(8.dp))
        }

        items(topGenresList.chunked(2)) { row ->
            val first = row.first()
            val second = row.last()
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Row {
                    SearchItem(searchCategory = first, (screenWidth / 2.3).toInt())
                    Spacer(modifier = Modifier.width(8.dp))
                    SearchItem(searchCategory = second, (screenWidth / 2.3).toInt())
                }
            }
        }

        item {
            Text(
                text = stringResource(id = R.string.browse_all),
                color = Color.White,
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(Modifier.height(8.dp))
        }

        items(allGenresList.chunked(2)) { row ->
            val first = row.first()
            val second = row.last()
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Row {
                    SearchItem(searchCategory = first, (screenWidth / 2.3).toInt())
                    Spacer(Modifier.width(8.dp))
                    SearchItem(searchCategory = second, (screenWidth / 2.3).toInt())
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}