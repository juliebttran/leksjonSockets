package com.example.leksjonsockets.seksjon2til5

import java.net.InetAddress
import java.net.ServerSocket
import java.net.Socket
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ChatServer(private val port: Int) {
    private var serverSocket: ServerSocket? = null

    suspend fun awaitClient(): Socket = withContext(Dispatchers.IO) {
        val listening = serverSocket ?: ServerSocket(port)
        serverSocket = listening
        listening.accept()
    }

    fun close() {
        serverSocket?.close()
    }
}