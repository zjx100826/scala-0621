package com.atguigu.charpter04

object $04_While {
  /**
   * scan的while 和 do while 和java的一模一样
   *
   * while与do-while的区别：
   *    while是先判断再执行
   *     do-while先执行在判断[无论如何最少执行一次]
   */
  def main(args: Array[String]): Unit = {
     var  i = 1
    while(i<=5){
      println(i)
      i = i + 1
    }

    println("*"*100)
    var j=1
    do{
      println(j)
      j+=1
    }while(j<=5)
  }

}
