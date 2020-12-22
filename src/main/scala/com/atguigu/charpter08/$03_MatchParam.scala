package com.atguigu.charpter08

import scala.util.Random

object $03_MatchParam {
  /**
   *scala中可以匹配所有的字面量，包括字符串，字符，数字，布尔值等等
   */
  def main(args: Array[String]): Unit = {
    val list=List("hadoop","flume",true,2,10.2,false)
    val num=Random.nextInt(list.length)
    println(num)
    val value = list(num)
    value match {
      case "hadoop" =>println("hadoop...............")
      case "flume" =>println("flume...........")
      case true =>println("true.............")
      case 2 =>println("2.............")
      case 10.2 =>println("10.2.................")
      case false => println("false.............")
      case _  => println("qita")
    }
  }
}
