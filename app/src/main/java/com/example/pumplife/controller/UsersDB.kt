package com.example.pumplife.controller

import com.example.pumplife.model.CourseBlock
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

object UsersDB {
    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference("Users")
    var data = arrayListOf<CourseBlock>()
    lateinit var postListener: ValueEventListener
    var isFirst = true

}
