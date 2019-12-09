package com.example.pumplife.controller

import android.util.Log
import com.example.pumplife.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


object UsersDB {
    var mAuth = FirebaseAuth.getInstance()
    private val database = FirebaseDatabase.getInstance()
    private val myRef = database.reference.child("Users")
    lateinit var postListener: ValueEventListener


    fun createUser(name: String, email: String) {
        val userId = mAuth.currentUser!!.uid
        AppController.user = User(userId, name, email, "", arrayListOf())
        saveUser()
    }

    fun saveUser() {
        myRef.child(AppController.user.id).setValue(AppController.user)
    }

    fun getUserData() {
        postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val listUser = arrayListOf<User>()
                for (dataValues in dataSnapshot.children) {
                    val userModel: User =
                        dataValues.getValue(User::class.java)!!
                    listUser.add(userModel)
                }

                AppController.user = listUser.find { it.id == mAuth.currentUser!!.uid }!!
                Log.d("USER", "Получены данные для пользователя ${AppController.user.name}")
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("database", "loadPost:onCancelled", databaseError.toException())
            }
        }
        myRef.addValueEventListener(postListener)
    }

}
