package com.atguigu.charpter02

object $03_ParamDefined {

  /**
   * java中变量定义: 类型 变量名 = 值 int age =10;
   * scala中认为变量名比较重要，所以在定义变量的时候 变量名在前 变量类型在后，中间通过:分割
   *     语法: val/var 变量名:变量类型 = 值  val age:Int =10
   *     val/var的区别:
   *       val定义的变量不可以被重写赋值,val类似java的final
   *       var定义的变量可以被重写赋值
   *       一般推荐使用val定义变量
   *     在定义变量的时候，变量类型可以省略，省略之后scala会自动推断类型
   */

  def main(args: Array[String]): Unit = {
    val age : Int =24
    val age1  =24

    var name:String ="zjx"
    name = "wangwu"
    println(name)
  }

}
