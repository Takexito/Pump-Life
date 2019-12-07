package com.example.pumplife.model

data class UserData (
    //val courses: ArrayList<Course> = arrayListOf()//id course
//num fo end
//is test
    val courseId: Int,
    val cardNum: Int,
    val isTest: Boolean,
    val answer: ArrayList<String> = arrayListOf()
)