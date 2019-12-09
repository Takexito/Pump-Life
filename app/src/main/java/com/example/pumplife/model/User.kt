package com.example.pumplife.model


class User (
    val id: String = "0",
    val name: String = "UserName",
    val email: String = "Takexito@gmail.com",
    val image: String = "",
    val userData: ArrayList<UserData> = arrayListOf()//list
)