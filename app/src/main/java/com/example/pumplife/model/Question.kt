package com.example.pumplife.model

class Question(
    private val text: String,
    private val correctAnswer: Int,
    private val answerOptions: ArrayList<String>
    ){

    private var currAnswer = -1

    fun isCorrectAnswer(answer: String): Boolean{
        var answerNum = -1
        answerOptions.forEach{
            if(it == answer) answerNum = answerOptions.indexOf(it)
        }
        return answerNum == correctAnswer
    }

    fun nextAnswer(): String?{
        if (currAnswer >= answerOptions.size - 1) return null
        return answerOptions[currAnswer++]
    }

    fun numOfAnswers(): Int{
        return answerOptions.size
    }
}