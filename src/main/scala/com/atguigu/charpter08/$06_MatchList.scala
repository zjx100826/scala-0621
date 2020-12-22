package com.atguigu.charpter08

object $06_MatchList {
  /**
   * 匹配List
   */
  def main(args: Array[String]): Unit = {
    val list:Any = List(1, "scala", 5,10)
    //根据List特有的::  匹配
    list match {
      case x :: Nil =>println(s"集合中只有一个元素 ${x}")
      case x :: y :: z :: Nil =>println(s"集合中有三个元素: ${x}  ${y}  ${z}   ${Nil}")
        //tail用于标识 其他所有元素
     case x :: tail =>println(s"集合中至少有一个元素:${x},其他元素为:${tail} ")
      case (x:Int) :: bb =>println(s"集合中至少有一个元素:${x},而且为Int,其他元素为:${bb}")
      case (x:String) :: cc =>println(s"集合中至少有一个元素:${x},而且为String,其他元素为:${cc}")
      case _ => println ("其他情况")
    }

    list match {
      case List(x) =>println(s"集合中只有一个元素:${x}")
      case List(x,y,z) =>println(s"集合中有三个元素分别为:${x} ${y} ${z}")
     // case List(x:Int,_*) =>println("集合中至少有一个元素,且第一个为Int类型")
      case List(a,x:String,_*) =>println("集合中第二个为String类型,后面不管有多少个,或者是什么类型")
      case _ =>println("不在匹配范围")
    }
  }
}
