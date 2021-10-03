package com.example.disher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.disher.navigation.DisherNavigation
import com.example.disher.ui.theme.DisherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisherTheme {
                DisherApp()
            }
        }
    }
}


@Composable
fun DisherApp() {
    DisherNavigation()
}


//www.themealdb.com/api/json/v1/1/categories.php