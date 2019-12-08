package com.example.pumplife.controller

import android.util.Log
import com.example.pumplife.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


object UsersDB {
    var mAuth = FirebaseAuth.getInstance()
    val database = FirebaseDatabase.getInstance()
    val myRef = database.reference.child("Users")
    var currUser = User(userData = arrayListOf())
    lateinit var postListener: ValueEventListener
    var isFirst = true


    fun createUser(name: String,  email: String){
        val userId = mAuth.currentUser!!.uid
        currUser = User(userId, name, email,"", arrayListOf())
        saveUser()
    }

    fun saveUser(){
        myRef.child(currUser.id).setValue(currUser)
//        myRef.child(user.id).child("id").setValue(user.id)
//        myRef.child(user.id).child("name").setValue(user.name)
//        myRef.child(user.id).child("email").setValue(user.email)
//        myRef.child(user.id).child("image").setValue(user.image)
//        myRef.child(user.id).child("userData").setValue(user.userData)
    }

    fun getUserData(){
        postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val listUser = arrayListOf<User>()
                for (dataValues in dataSnapshot.children) {
                    val userModel: User =
                        dataValues.getValue(User::class.java)!!
                    listUser.add(userModel)
                }

                currUser = listUser.find { it.id == mAuth.currentUser!!.uid }!!
                setUser()
                Log.d("USER", "Получены данные для пользователя ${currUser.name}")
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("database", "loadPost:onCancelled", databaseError.toException())
            }
        }
        myRef.addValueEventListener(postListener)
    }

    fun setUser(){
        CourseManager.user = currUser
    }
}
