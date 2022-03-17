package com.cockroach.composeuipractice.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.cockroach.composeuipractice.data.SearchCategory
import com.cockroach.composeuipractice.extension.toDp

@Composable
fun SearchItem(searchCategory: SearchCategory, width: Int) {
    Box(
        Modifier
            .size(width = width.toDp.dp, height = 100.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(searchCategory.color)
    ) {
        Column {
            Text(
                text = stringResource(id = searchCategory.title),
                color = Color.White,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(8.dp)
            )

            Box(contentAlignment = Alignment.BottomEnd) {
                Row {
                    Spacer(modifier = Modifier.width(100.dp))
                    Image(
                        painter = painterResource(id = searchCategory.image),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                            .rotate(30f)
                    )
                }
            }
        }
    }
}