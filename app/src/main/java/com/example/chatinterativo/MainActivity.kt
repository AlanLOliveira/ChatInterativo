package com.example.chatinterativo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

const val USER_ID = 0
const val OTHER_ID = 1       //declarar constante para simular um bate papo


class MainActivity : AppCompatActivity() {

    private var fromUser = true // Validar usuário

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        setUpListeners()

    }

    private fun setupRecyclerView() {
        //configurando RecyclerView
        message_list.layoutManager = LinearLayoutManager(this)
        message_list.adapter = MessageAdapter()
    }

    private fun setUpListeners() {
        //val sendButton: Button = findViewById(R.id.send_button) caso não tivesse o plugin android extensions
        //Criando ação do botão enviar
        send_button.setOnClickListener {
            val messageText = message_edittext.text.toString()
            message_edittext.setText("")                        //limpar o campo digitado
            //message_textview.text = message                     // mostrar a mensagem no chat
            val adapter = message_list.adapter
            if (adapter is MessageAdapter) {
                val message = ChatMessage(messageText, if (fromUser) USER_ID else OTHER_ID)
                adapter.addItem(message)
                message_list.scrollToPosition(adapter.itemCount - 1) // mensagem vai subindo
                fromUser = !fromUser
            }

        }
    }

}

