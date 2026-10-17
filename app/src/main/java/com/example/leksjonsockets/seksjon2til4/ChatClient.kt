package com.example.leksjonsockets.seksjon2til4

import java.net.Socket
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ChatClient(private val host: String, private val port: Int) {
    private var socket: Socket? = null

    suspend fun connect(): Socket = withContext(Dispatchers.IO) {
        val opened = Socket(host, port)
        socket = opened
        opened
    }

    fun close() {
        socket?.close()
    }
}