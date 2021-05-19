package com.example.chatinterativo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

const val SENT_MESSAGE = 0
const val RECEIVID_MESSAGE = 1


    // : Herdar o tipo de adapter > parametrizar > construtor base
class MessageAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        private val items: MutableList<ChatMessage> = mutableListOf ()

        fun addItem(message: ChatMessage){
            items.add(message)
            notifyDataSetChanged()  // notificar mudança nos dados, força a recycleview a se redesenhar
        }

        //função responsável por ler arquivo de layout e criar objeto viewHolder e configura e segura as views
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var card = LayoutInflater.from(parent.context).inflate(
            if (viewType == SENT_MESSAGE)
                R.layout.sent_card
            else R.layout.received_card,parent, false)
           return messageViewHolder(card)
        // segurar a referencia das Views, sem precisar procurar a View  sem necessidade de procurar
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val currentItem = items[position]
            if (holder is messageViewHolder){
                holder.messageTextView.text = currentItem.text
                holder.momentTextView.text = currentItem.moment
            }
        }

        override fun getItemCount(): Int {
          return items.size         //Definindo quantas coisas quero exibir ou tamanho da nosa lista
        }

        //class que deriva de viewholder
        class messageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            val messageTextView: TextView = itemView.findViewById(R.id.message_textview)
            val momentTextView: TextView = itemView.findViewById(R.id.moment_textview)
           }

        override fun getItemViewType(position: Int): Int {
            val message = items[position]
            return if (message.senderId == USER_ID){
                SENT_MESSAGE
            }else{
                RECEIVID_MESSAGE
            }

        }
    }