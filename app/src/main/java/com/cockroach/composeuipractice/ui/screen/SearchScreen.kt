package com.cockroach.composeuipractice.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.cockroach.composeuipractice.R

@Composable
fun SearchScreen() {
    val hint = stringResource(id = R.string.hint_search)
    var text by remember { mutableStateOf("") }
    var isHintDisplayed by remember { mutableStateOf(hint != "") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Text(
            text = ("Search"),
            color = Color.White,
            fontSize = MaterialTheme.typography.h2.fontSize,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        //Search Box
        Box(
            modifier = Modifier
                .padding(horizontal = 10.dp)
        ) {
            BasicTextField(
                value = text,
                onValueChange = {
                    text = it
                },
                maxLines = 1,
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(5.dp))
                    .padding(horizontal = 20.dp, vertical = 20.dp)
                    .onFocusChanged {
                        isHintDisplayed = !it.isFocused && text == ""
                    }
            )

            if (isHintDisplayed) {
                Row {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 12.dp)
                    )
                    Text(
                        text = hint,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 12.dp),
                        style = MaterialTheme.typography.subtitle1
                    )
                }
            }
        }
    }
}