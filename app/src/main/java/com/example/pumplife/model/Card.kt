package com.example.pumplife.model

open class Card(val isTest: Boolean = false){
    fun isTestCard(): Boolean{
        return isTest
    }
}
