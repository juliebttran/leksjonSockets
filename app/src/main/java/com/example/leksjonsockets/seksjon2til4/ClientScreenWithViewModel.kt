package com.example.leksjonsockets.seksjon2til4

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ClientScreenWithViewModel (
    modifier: Modifier = Modifier,
    viewModel: ClientViewModel = viewModel(),
    ){
    val received by viewModel.received.collectAsStateWithLifecycle()
    val error by viewModel.error.collectAsStateWithLifecycle()
    val closed by viewModel.closed.collectAsStateWithLifecycle()

    ClientScreen(
        received = received,
        error = error,
        closed = closed,
        modifier = modifier
    )
}