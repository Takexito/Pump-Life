package com.example.pumplife.model

class TestCard(
    val title: String,
    private val questionsList: ArrayList<Question>,
    var isComplete: Boolean = false,
    var currQuestion: Int,
    var correctAnswerNum: Int = 0
) : Card {
    override fun isTestCard(): Boolean {
        return true
    }

    fun nextQuestion(): Question? {
        if (currQuestion >= questionsList.size - 1) return null
        return questionsList[currQuestion++]
    }

    fun checkAnswer(answer: String): Boolean {
        if (questionsList[currQuestion].isCorrectAnswer(answer)) {
            correctAnswerNum++
            return true
        }
        return false
    }

}