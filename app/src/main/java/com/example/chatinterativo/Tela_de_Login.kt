package com.example.chatinterativo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.service.controls.actions.BooleanAction
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_de_login.*


 lateinit var email: String
 lateinit var senha: String

class Tela_de_Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_de_login)

        fun validarEmail():Boolean{
            return textLogin.text.toString().contains("@") && textLogin.text.toString().contains(".com")
        }
        fun validarSenha(): Boolean{
            return textPassword.text.toString().length >= 8
        }


        inChat.setOnClickListener {R.id.inChat
                        if (validarEmail() && validarSenha()) {
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            val email = textLogin.text.toString()
                            val senha = textPassword.text.toString()

                        }else{
                            Toast.makeText(this, "Email ou Senha Inválido", Toast.LENGTH_LONG).show()
                             }
                }

            }

          }







