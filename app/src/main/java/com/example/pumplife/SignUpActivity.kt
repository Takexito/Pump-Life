package com.example.pumplife

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        go_to_sign_in_button.setOnClickListener{
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }


        sign_up_button.setOnClickListener{
            val email = edit_email.text.toString()
            val password = edit_pass.text.toString()
            val confPass = repeat_pass.text.toString()
            if (password == confPass && password.isNotEmpty() && email.isNotEmpty()) {

                //Добавление пользователя в бд

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else if (password == confPass) {
                Toast.makeText(this, "Все поля должны быть заполнены", Toast.LENGTH_SHORT).show()
            } else Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show()
        }
    }

}
