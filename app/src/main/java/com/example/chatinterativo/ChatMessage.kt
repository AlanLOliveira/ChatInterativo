package com.example.chatinterativo

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

class ChatMessage(val text: String, val senderId: Int, val timestamp: Long = Date().time) {
val moment : String
get() = SimpleDateFormat("HH:mm").format(timestamp) //puxar a data do sistema

}
