package com.example.leksjonsockets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.leksjonsockets.seksjon2til4.ClientScreenWithViewModel
import com.example.leksjonsockets.seksjon2til4.ServerScreenWithViewModel
import com.example.leksjonsockets.seksjon5til6.ChatScreenWithViewModel
import com.example.leksjonsockets.ui.theme.LeksjonSocketsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LeksjonSocketsTheme {
                ChatScreenWithViewModel()
            }
        }
    }
}
