package com.example.pumplife.model

class Course (
    val id: Int,
    val title: String/*,
     val description: String,
     val image: Image,
     private val cardList: ArrayList<Card>,
     val theme: Themes,
     var completedCardNum: Int = 0,
     var currentCardNum: Int = 0 */
 ){
     /*private val cardNum: Int = cardList.size

     fun nextCard(): Card?{
         if (currentCardNum >= cardList.size - 1) return null
         completedCardNum++
         return cardList[currentCardNum++]
     }

     fun skipCard(): Card{
         return cardList[currentCardNum]
     }

     fun isFullyCompleted(): Boolean{
         return cardList.size == completedCardNum
     }

     fun getPercent(): Int{
         return (completedCardNum.toFloat()/currentCardNum.toFloat()).toInt() * 100
     } */

 }

 /*class CourseLab(){
     val courseList: MutableList<Course>

     init {
         courseList = mutableListOf()
         for (i in 0..10) {
             val course = Course(i,"Title $i")
             courseList.add(course)
         }
     }
 } */