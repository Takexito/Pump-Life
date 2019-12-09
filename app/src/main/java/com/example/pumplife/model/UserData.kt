package com.example.pumplife.model

data class UserData (

    var courseId: Int = 0,
    var cardNum: Int = 0,
    var isTest: Boolean = false,
    var answer: ArrayList<String> = arrayListOf()
)