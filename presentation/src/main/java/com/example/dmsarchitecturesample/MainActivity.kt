package com.example.dmsarchitecturesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.dmsarchitecturesample.feature.auth.signin.SignInScreen
import com.example.dmsarchitecturesample.ui.theme.DMSArchitectureSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DMSArchitectureSampleTheme {
                SignInScreen()
            }
        }
    }
}