package com.example.pumplife

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pumplife.controller.UsersDB
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    private var mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val user = mAuth.currentUser

        if (user !== null) {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            Log.d("USER", "Запрос данных")
            UsersDB.getUserData()
            startActivity(intent)
        }

        go_to_sign_up_button.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        sign_in_button.setOnClickListener {
            val email = edit_email.text.toString()
            val password = edit_pass.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                mAuth.signInWithEmailAndPassword(email, password)
                    .addOnSuccessListener {
                        val intent = Intent(this, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    }

                    .addOnFailureListener{
                        Toast.makeText(this, "${it.message}", Toast.LENGTH_SHORT).show()
                    }

            } else Toast.makeText(this, "Введите почту и пароль", Toast.LENGTH_LONG).show()
        }

        stop_button.setOnClickListener {
            //Выход из Activity
            finish()
        }

        delete_email_button.setOnClickListener {
            edit_email.text = null
        }
        delete_password_button.setOnClickListener {
            edit_pass.text = null
        }
    }


}