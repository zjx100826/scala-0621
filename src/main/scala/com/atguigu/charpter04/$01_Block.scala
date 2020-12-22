package com.atguigu.charpter04

object $01_Block {
  /**
   * 块表达式:
   * 基本语法:{
   * 代码块
   * }
   * 块表达式有返回值的话,返回值就为{}中的最后一个表达式的值
   */

  def main(args: Array[String]): Unit = {
    val block ={
      println("hello")
      println("全都是泡沫")
      val result=1+1
      result
    }
    println(block)

    //间接的三元表达式
    val flag:Boolean=true
    val a =if(flag)1 else 0
    println(a)


  }

}
