package com.example.leksjonsockets.seksjon2til4

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

const val HOST = "10.0.2.2"
class ClientViewModel : ViewModel() {
    private val client = ChatClient(HOST, PORT)

    private val _received = MutableStateFlow<String?>(null)
    val received: StateFlow<String?> = _received.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    private val _closed = MutableStateFlow<Boolean>(false)
    val closed: StateFlow<Boolean> = _closed.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val socket = client.connect()
                val connection = Connection(socket)

                connection.send("Hei fra klienten!")

                val response = connection.receive()
                if(response != null) {
                    _received.value = response
                } else {
                    _closed.value = true
                }
            } catch (e: IOException) {
                _error.value = e.toString()
            }
        }
    }
}