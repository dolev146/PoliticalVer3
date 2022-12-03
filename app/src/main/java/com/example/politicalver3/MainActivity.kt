package com.example.politicalver3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.politicalver3.ui.theme.PoliticalVer3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PoliticalVer3Theme {
                // A surface container using the 'background' color from the theme
                Navigation()
            }
        }
    }
}

