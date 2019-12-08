package com.example.pumplife.model


class Course (
    val id: Int = 0,
    val title: String = "title",
    val description: String = "Description of this course",
    val image: String = "https://sun9-60.userapi.com/c858032/v858032528/10d752/9OdTprLe5EY.jpg",
    val cardList: ArrayList<TheorCard> = arrayListOf(TheorCard("Card Title", "Lesson number 1. Just do it!", false), TheorCard("Card Title2", "Lesson number 2. Just do it!", false)),
    val testCard: TestCard = TestCard(),
    var testComplete: Boolean = false,
    val theme: Themes = Themes.FINANCE,
    var completedCardNum: Int = 0,
    var currentCardNum: Int = completedCardNum
 ){
     private val cardNum: Int = cardList.size

     fun nextCard(): Card?{
         if (currentCardNum >= cardList.size) return null

         return cardList[completedCardNum++]
     }

    fun preCard(): Card?{
        if (completedCardNum - 1 < 0 ) return null
        return cardList[completedCardNum - 1]
    }

     fun isFullyCompleted(): Boolean{
         return cardList.size == completedCardNum
     }

     fun percent(): Int{
         return ((completedCardNum.toFloat()/cardList.size.toFloat()) * 100).toInt()
     }

 }