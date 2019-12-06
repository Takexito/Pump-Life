package com.example.pumplife.model

class TestCard(
    val title: String = "Test Card",
    val questionsList: ArrayList<Question> = arrayListOf(Question()),
    var isComplete: Boolean = false,
    var currQuestion: Int = 0,
    var correctAnswerNum: Int = 0
): Card() {
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