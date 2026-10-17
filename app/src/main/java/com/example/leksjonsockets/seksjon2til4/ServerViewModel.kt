package com.example.leksjonsockets.seksjon2til4

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import java.io.IOException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
const val PORT = 12345
class ServerViewModel : ViewModel() {
    private val server = ChatServer(PORT)
    private var connection: Connection? = null
    private val _client = MutableStateFlow<String?>(null)
    val client: StateFlow<String?> = _client.asStateFlow()
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()
    init {
        viewModelScope.launch {
            try {
                val socket = server.awaitClient()
                connection = Connection(socket)
                _client.value = socket.inetAddress.hostAddress
            } catch (e: IOException) {
                _error.value = e.toString()
            }
        }
    }

    override fun onCleared() {
        connection?.close()
        server.close()
    }
}