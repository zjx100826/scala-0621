package com.atguigu.charpter08

import scala.reflect.runtime.ReflectionUtils.PrimitiveOrArray

object $05_MatchArray {
  /**
   * 匹配数组
   */
  def main(args: Array[String]): Unit = {
    val array:Any = Array(10, 21, 30,"hello")
    array match {
      case Array(x) =>println(s"数组中只有一个元素:${x}")
      case Array(x,y,z) =>println(s"数组中有三个元素:${x} ${y} ${z}")
      case Array(x:Int,_*) =>println(s"数组有至少有一个元素,并且第一个元素为Int:${x}")
      case Array(x:Int,_*) if(x%2==0) =>println(s"数组中至少有一个元素,而且第一个元素为Int,还是偶数:${x}")
      case Array(z,x:Int,_*) if(x%2!=0) =>println(s"数组中至少有一个元素,而且第一个元素为Int,还是奇数:${x}")
      case Array(x:Int,y:Int,z:Int) =>println(s"数组中有三个元素,而且全为Int: 分别为 ${x} ${y} ${z}")
      case Array(10,_*) =>println(s"数组是以10开头的,后面不管有多少元素 ")
    }

    array match {
      case x:Array[String] => println("String类型............")
      case x:Array[Int] =>println("Int类型..............")
      case x:Array[Double] =>println("Double类型............")
      case x:Array[Any] =>println("Any类型..........")
    }
  }

}
