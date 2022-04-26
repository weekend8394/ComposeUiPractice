package com.cockroach.composeuipractice

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.cockroach.composeuipractice.ui.MainScreen
import com.cockroach.composeuipractice.ui.theme.ComposeUiPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUiPracticeTheme(darkTheme = true){
                MainScreen()
            }
        }
    }
}
