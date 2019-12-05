package com.example.pumplife

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        go_to_sign_up_button.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        sign_in_button.setOnClickListener{
            val email = edit_email.text.toString()
            val password = edit_pass.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {

                //Вход пользователя по бд

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
            } else Toast.makeText(this, "Введите почту и пароль", Toast.LENGTH_LONG).show()
        }

        stop_button.setOnClickListener{
            //Выход из Activity
            finish()
        }

        delete_email_button.setOnClickListener{
            edit_email.text = null
        }
        delete_password_button.setOnClickListener{
            edit_pass.text = null
        }
    }



}
