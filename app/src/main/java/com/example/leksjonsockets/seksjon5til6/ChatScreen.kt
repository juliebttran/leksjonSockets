package com.example.leksjonsockets.seksjon5til6

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.leksjonsockets.seksjon2til4.Message

@Composable
fun ChatScreen(
    isServer: Boolean?,
    messages: List<Message>,
    draft: String,
    onDraftChanged: (String) -> Unit,
    onStartServer: () -> Unit,
    onStartClient: () -> Unit,
    onSend: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            if (isServer == null) {
                // Før rollen er valgt: Vis velkomst og to knapper
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Velg din rolle", style = MaterialTheme.typography.headlineMedium)
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = onStartServer) {
                        Text("Start som Server")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = onStartClient) {
                        Text("Start som Klient")
                    }
                }
            } else {
                // Etter rollen er valgt: Vis rolle, meldinger og skrivefelt
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = if (isServer) "Rolle: Server" else "Rolle: Klient",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    LazyColumn(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        items(messages) { message ->
                            Text(
                                text = (if (message.fromMe) "Meg: " else "Motpart: ") + message.text,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }

                // Skrivefelt og Send-knapp med løftet tilstand
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = draft,
                        onValueChange = onDraftChanged,
                        singleLine = true,
                        modifier = Modifier.weight(1f),
                        placeholder = { Text("Skriv melding...") }
                    )
                    Button(onClick = { onSend(draft) }) {
                        Text("Send")
                    }
                }
            }
        }
    }
}
