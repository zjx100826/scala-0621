package com.atguigu.charpter02

import scala.io.{Source, StdIn}

object $05_StdIn {

  /**
   * 键盘输入
   *  java:scanner
   *  scala:StdIn
   */
  def main(args: Array[String]): Unit = {
    //val str :String=StdIn.readLine("输入一个数据")
    //println(str)

    //println("请输入一个整数:")
    //val str2 =StdIn.readInt() //只能输入整数
    //println(str2)t

    println("请输入一个布尔类型:")
    val str3=StdIn.readBoolean()
    println(str3)

    //文件操作----读取一个文件
    val source=Source.fromFile("E:\\aa.txt","utf-8")
    val result =source.getLines().toBuffer
    println(result)
  }

}
