package com.atguigu.charpter02

object $07_TypeConversion {

  /**
   * 类型转换:
   *   1、数字之间的转换
   *      低精度能够自动转成高精度
   *      高精度的不能自动转成低精度的,要想转换需要调用toXXX方法
   *   2、数字和字符串的转换
   *      数字转字符串:数字拼接空字符串
   *      字符串转数字:调用toXXX方法
   */
  def main(args: Array[String]): Unit = {
    //低精度转高精度
    val a =10
    val c:Double=a
    println(c)

    //高精度转低精度
    val a1=10.0
    val b1:Int=a1.toInt
    println(b1)

    println("&&"*50)
    //数字转字符串
    val a2 = 10
    val b2 :String=a2.toString
    println(b2)

    println("*"*100)
   //字符创转数字
    val a3 ="8"
    val b3:Int=a3.toInt
    println(b3)

    val a4 ="8.02"
    val b4:Double=a4.toDouble
    println(b4)
  }

}
