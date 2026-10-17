package com.example.leksjonsockets.seksjon5

import androidx.lifecycle.ViewModel
import com.example.leksjonsockets.seksjon2til4.Connection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.IOException

class ChatViewModel : ViewModel() {
    private val _lastLine = MutableStateFlow<String?>(null)
    val lastLine: StateFlow<String?> = _lastLine.asStateFlow()

    private val _closed = MutableStateFlow<Boolean>(false)
    val closed: StateFlow<Boolean> = _closed.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    private suspend fun listen(open: Connection) {
        try {
            while (true) {
                val line = open.receive() ?: break
                _lastLine.value = line
            }
        }catch (e: IOException) {

        }
        _closed.value = true
    }
}