package com.cockroach.composeuipractice.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
//        item{ Spacer(modifier = Mo)}
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}