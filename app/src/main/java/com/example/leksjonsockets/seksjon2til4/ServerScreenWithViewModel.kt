package com.example.leksjonsockets.seksjon2til4

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ServerScreenWithViewModel (
    modifier: Modifier = Modifier,
    viewModel: ServerViewModel = viewModel(),
    ){
    val client by viewModel.client.collectAsStateWithLifecycle()
    val error by viewModel.error.collectAsStateWithLifecycle()

    ServerScreen(
        client = client,
        error = error,
        modifier = modifier
    )
}