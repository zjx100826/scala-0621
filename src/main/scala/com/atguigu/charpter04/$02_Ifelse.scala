package com.atguigu.charpter04

import scala.io.StdIn

object $02_Ifelse {
  /**
   * java中的if语句的三种形式:
   * 1单分支:if
   * 2双分支 : if else
   * 3多分支: if else if -..else if else
   *
   * scan中的if用法和java中的一样,只是多了一个返回值
   */

  def main(args: Array[String]): Unit = {
    //单分支:输入人的年龄，如果该同志的年龄大于18岁，则输出“age > 18”
//    println("请输入你的年龄:")
//    val age=StdIn.readInt()

//    if( age<18){
//      println("age<18")
//    }

    //双分支:输入年龄，如果年龄大于18岁，则输出“age >18”。否则，输出“age <= 18”
//          if(age>18){
//            println("age>18")
//          }else{
//            println("age<=18")
//          }


    //多分支:岳小鹏参加Scala考试，他和父亲岳不群达成承诺：如果，成绩为100分时，奖励一辆BM；成绩为(80，99]时，
          //  奖励一台iphone；其它时，什么奖励也没有
//    println("请输入你的分数:")
//    val grade=StdIn.readInt()
//    if(grade==100){
//      println("奖励一辆BM")
//    }else if(grade>80 && grade<99){
//      println("奖励一台iphone")
//    }else{
//      println("什么奖励都没有")
//    }

    //嵌套:参加百米运动会，根据性别提示进入男子组或女子组。如果是女子组，用时8秒以内进入决赛，否则提示淘汰。
    println("请输入你的性别:")
    val sex=StdIn.readChar()
    if(sex=='男'){
      println("运动会释放你的魅力")
    }else{
      println("请输入你的成绩:")
      val miaoshu=StdIn.readInt()
      if(miaoshu<=8){
        println("进入决赛")
      }else{println("淘汰")}
    }
  }



}
