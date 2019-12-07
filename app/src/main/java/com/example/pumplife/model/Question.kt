package com.example.pumplife.model

class Question(
    val text: String = "Question 1",
    val correctAnswer: Int = 0,
    val answerOptions: ArrayList<String> = arrayListOf("true", "false", "trueee")
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