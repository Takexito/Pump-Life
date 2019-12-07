package com.example.pumplife.model

class TheorCard(
    val title: String,
    val body: String,
    var isComplete: Boolean
    ) : Card {
    override fun isTestCard(): Boolean {
        return false
    }
}