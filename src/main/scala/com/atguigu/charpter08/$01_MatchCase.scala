package com.atguigu.charpter08

import scala.io.StdIn

object $01_MatchCase {
  /**
   * 类似于java的case  java的case只能匹配int/char/string类型
   *  而scala可以匹配任意类型
   * 语法:变量/值 match{
   *   case " 值1" =>{执行体}
   *   case " 值2" =>{执行体}
   *   ..
   *   case _ =>其他操作,不使用的情况下用_ 替代,使用的话则不可以
   * }
   */

  def main(args: Array[String]): Unit = {
    val lines=StdIn.readLine("请输入一行数据:")
    val unit = lines match {
      case "hadoop" => {
        println("输入的是hadoop")
        10
      }
      case "spark" => println("输入的是spark")
      case _ => println("输入的不合理")
    }
    println(unit)
  }
}
