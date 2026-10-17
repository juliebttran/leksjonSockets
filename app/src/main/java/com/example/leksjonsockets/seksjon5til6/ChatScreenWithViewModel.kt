package com.example.leksjonsockets.seksjon5til6

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ChatScreenWithViewModel(
    modifier: Modifier = Modifier,
    viewModel: ChatViewModel = viewModel(),
) {
    val isServer by viewModel.isServer.collectAsStateWithLifecycle()
    val messages by viewModel.messages.collectAsStateWithLifecycle()
    var draft by rememberSaveable { mutableStateOf("") }

    ChatScreen(
        isServer = isServer,
        messages = messages,
        draft = draft,
        onDraftChanged = { draft = it },
        onStartServer = { viewModel.startAsServer() },
        onStartClient = { viewModel.startAsClient() },
        onSend = { text ->
            if (text.isNotBlank()) {
                viewModel.send(text)
                draft = ""
            }
        },
        modifier = modifier
    )
}