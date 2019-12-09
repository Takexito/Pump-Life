package com.example.pumplife.ui.fragment.cabinet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_change_password.*
import kotlinx.android.synthetic.main.fragment_change_password.view.*

class ChangePasswordFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            com.example.pumplife.R.layout.fragment_change_password,
            container,
            false
        )

        val mAuth = FirebaseAuth.getInstance()
        val mDatabase = FirebaseDatabase.getInstance()
        val mRef = mDatabase.reference.child("Users")
        val user = mAuth.currentUser!!
        val emailUser = user.email!!

        view.change_password_button.setOnClickListener {
            val currentPass = edit_old_password.text.toString()
            val newPass = edit_new_password.text.toString()
            val confPass = edit_conf_password.text.toString()

            val credential = EmailAuthProvider.getCredential(emailUser, currentPass)

            user.reauthenticate(credential)
                .addOnSuccessListener {
                    if (newPass == confPass) {
                        user.updatePassword(newPass)
                            .addOnSuccessListener {
                                Toast.makeText(
                                    context,
                                    "Пароль успешно изменен",
                                    Toast.LENGTH_SHORT
                                ).show()
                                dismiss()
                            }
                            .addOnFailureListener {
                                Toast.makeText(context, "${it.message}", Toast.LENGTH_SHORT).show()
                            }
                    } else {
                        Toast.makeText(context, "Пароли не совпадают", Toast.LENGTH_SHORT).show()
                    }
                }
                .addOnFailureListener {
                    Toast.makeText(context, "${it.message}", Toast.LENGTH_SHORT).show()
                }
        }
        return view
    }
}

