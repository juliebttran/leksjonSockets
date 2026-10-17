package com.example.leksjonsockets.seksjon2til4

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.leksjonsockets.R
import com.example.leksjonsockets.ui.theme.LeksjonSocketsTheme

@Composable
fun ClientScreen(
    received: String?,
    error: String?,
    closed: Boolean,
    modifier: Modifier = Modifier,
){
    Scaffold(modifier = modifier.fillMaxSize()
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            if (error != null) {
                Text(text = error)
            } else if (closed) {
                Text(text = stringResource(R.string.closed))
            } else if (received != null) {
                Text(text = received)
            } else {
                Text(text = stringResource(R.string.client_waiting))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ClientScreenPreview() {
    LeksjonSocketsTheme {
        ClientScreen(received = "null", error = null, closed = true)
    }
}