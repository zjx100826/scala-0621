package com.atguigu.charpter03

object $01_Operator {

  /**
   * java中的运算符有:
   * 1算术运算符: + - * / %..
   * 2逻辑运算符: & | !
   * 3位运算符: >> << >>>
   * 4比较运算符 >  >= < <= != =
   * 5赋值运算符 = += -=
   *
   * scala中也具有这样相同的运算符,但是没有三元运算符
   */

  def main(args: Array[String]): Unit = {
    val a =10
    val b =20
    val c=a+b
    println(c)

    val flag = 1==1&&2==2
    println(flag)

    val flag1 = 1==1&&2==3
    println(flag1)
  }
}
