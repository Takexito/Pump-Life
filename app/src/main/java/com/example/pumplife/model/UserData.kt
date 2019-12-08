package com.example.pumplife.model

data class UserData (
    //val courses: ArrayList<Course> = arrayListOf()//id course
//num fo end
//is test
    var courseId: Int,
    var cardNum: Int,
    var isTest: Boolean,
    var answer: ArrayList<String> = arrayListOf()
)