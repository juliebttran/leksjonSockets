package com.example.leksjonsockets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.leksjonsockets.seksjon2til5.ClientScreenWithViewModel
import com.example.leksjonsockets.seksjon2til5.ServerScreen
import com.example.leksjonsockets.seksjon2til5.ServerScreenWithViewModel
import com.example.leksjonsockets.ui.theme.LeksjonSocketsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LeksjonSocketsTheme {
                ServerScreenWithViewModel()
            }
        }
    }
}
