package com.example.pumplife.ui.cabinet

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.pumplife.SignInActivity
import com.example.pumplife.controller.CourseManager
import com.example.pumplife.controller.UsersDB
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_cabinet.*
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
        mRef.child(mAuth.currentUser!!.uid).child("name").addListenerForSingleValueEvent(object :
            ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                view.user_name.text = dataSnapshot.getValue(true).toString()
            }

            override fun onCancelled(error: DatabaseError) {}
        })

        view.change_avatar_button.setOnClickListener{
            Toast.makeText(activity, "Change avatar", Toast.LENGTH_LONG).show()

        }

        view.change_password_button.setOnClickListener{
            ChangePasswordFragment().show(childFragmentManager, "change_password_dialog")
        }

        view.change_user_button.setOnClickListener{
            mAuth.signOut()
            val intent = Intent(activity, SignInActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        user_name.text = CourseManager.user.name
        Log.d("USERNAME", CourseManager.user.name)
    }

}