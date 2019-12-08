package com.example.pumplife

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    private var mAuth = FirebaseAuth.getInstance()
    private var mDatabase = FirebaseDatabase.getInstance()
    private var mRef = mDatabase!!.reference.child("Users")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        go_to_sign_in_button.setOnClickListener {
            finish()
        }

        sign_up_button.setOnClickListener {
            val email = edit_email.text.toString()
            val password = edit_pass.text.toString()
            val confPass = repeat_pass.text.toString()
            if (password == confPass && password.isNotEmpty() && email.isNotEmpty()) {
                mAuth
                    .createUserWithEmailAndPassword(email, password)
                    .addOnSuccessListener {
                        var user = mAuth.currentUser!!.uid
                        mRef.child(user).child("id").setValue(mAuth.currentUser!!.uid)
                        mRef.child(user).child("name").setValue(edit_name.toString())
                        mRef.child(user).child("email").setValue(edit_email.toString())
                        mRef.child(user).child("image").setValue("")
                        mRef.child(user).child("userData").setValue(null)

                        val intent = Intent(this, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    }
                    .addOnFailureListener{
                        Toast.makeText(this, "${it.message}", Toast.LENGTH_SHORT).show()
                    }
            } else if (password == confPass) {
                Toast.makeText(this, "Все поля должны быть заполнены", Toast.LENGTH_SHORT).show()
            } else Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show()
        }

        stop_button.setOnClickListener {
            finish()
        }

        delete_email_button.setOnClickListener {
            edit_email.text = null
        }
        delete_name_button.setOnClickListener {
            edit_name.text = null
        }
        delete_password_button.setOnClickListener {
            edit_pass.text = null
        }
        delete_password_button_2.setOnClickListener {
            repeat_pass.text = null
        }
    }

}