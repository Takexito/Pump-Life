package com.example.pumplife.ui.cabinet

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.pumplife.SignInActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_cabinet.view.*



class CabinetFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val mAuth = FirebaseAuth.getInstance()
        val mDatabase = FirebaseDatabase.getInstance()
        val mRef = mDatabase.reference.child("Users")

        val view = inflater.inflate(com.example.pumplife.R.layout.fragment_cabinet, container, false)

        //Замена Username на имя пользователя
        //mRef.addValueEventListener(object : ValueEventListener {
//
        //    override fun onDataChange(dataSnapshot: DataSnapshot) {
        //        view.user_name.text = dataSnapshot.getValue(String::class.java)
        //    }
//
        //    override fun onCancelled(error: DatabaseError) {
        //        Toast.makeText(activity, "Failed to read value.", Toast.LENGTH_LONG).show()
        //        Log.w(TAG, "Failed to read value.", error.toException())
        //    }
        //})

        view.change_avatar_button.setOnClickListener{
            Toast.makeText(activity, "Change avatar", Toast.LENGTH_LONG).show()
        }

        view.change_password_button.setOnClickListener{
            Toast.makeText(activity, "Change password", Toast.LENGTH_LONG).show()
        }

        view.change_user_button.setOnClickListener{
            mAuth.signOut()
            val intent = Intent(activity, SignInActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        return view
    }

}