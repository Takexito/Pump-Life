package com.example.pumplife.model

class Card(    val title: String = "Theor Card",
               val body: String = "Body of theor card",
               var isComplete: Boolean = false){

    fun isTestCard(): Boolean{
        return false
    }
}
