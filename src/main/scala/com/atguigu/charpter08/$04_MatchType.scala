package com.atguigu.charpter08

import scala.util.Random

object $04_MatchType {
  /**
   * 匹配类型
   */
  def main(args: Array[String]): Unit = {
    val list=List("hadoop","flume",true,2,10.2,false)
     //这里已经指定是String类型的时候,下面匹配模式就无缘需要匹配了,只会有String类型,其他的报错
    //val list = List[String]("hadoop", "flume")
    val num = Random.nextInt(list.length)
    val value = list(num)
    println(value)

    value match {
      case _:String =>println("字符串类型")
      case _:Int =>println("Int类型")
      case _:Boolean =>println("Boolean类型")
      case _:Double =>println("Double类型")
      case _ =>println("其他类型")
    }
  }
}
