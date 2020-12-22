package com.atguigu.charpter09

object $03_ImplicitClass {
  /**
   * 隐式转换类： 对隐式转换方法的简写
   * 隐式转换类:  还是将一个对象转为另一个对象
   * 隐式转换类必须要有构造器,构造器的参数有且仅有一个，参数类型就是待转换类型
   * 隐式转换类不能处于最顶层，必须放在object/class/package object中
   */

    implicit class person(x:Int){
    val name="zhangsan"
    val age=20
  }

  def main(args: Array[String]): Unit = {
    val a =1
    println(1.name)
    println(1.age)
  }

}
