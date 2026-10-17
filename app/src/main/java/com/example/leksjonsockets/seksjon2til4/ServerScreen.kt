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
import com.example.leksjonsockets.ui.theme.LeksjonSocketsTheme
import com.example.leksjonsockets.R

@Composable
fun ServerScreen(
    client: String?,
    error: String?,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize()
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            if(error != null){
                Text(text= stringResource(R.string.error))
            }
            else if (client == null) {
                Text(text = stringResource(R.string.server_waiting))
            }
            else {
                Text(text = stringResource(R.string.client))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ServerScreenPreview() {
    LeksjonSocketsTheme {
        ServerScreen(client = null, error = null)
    }
}