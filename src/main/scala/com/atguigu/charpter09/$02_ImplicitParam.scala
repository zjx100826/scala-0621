package com.atguigu.charpter09

object $02_ImplicitParam {
  /***
   * 隐式参数的优先级高于默认值
   *
   *
  /**
   * 隐式转换参数：
   *     1、定义语法: implicit val 参数名:参数类型 = 值
   * 隐式转换参数一般都是悄悄的塞到到方法的参数列表中，
   * 在定义方法的时候必须指定哪个参数后续会传递隐式参数的值
   *     def 方法名(参数名:参数类型,..)(implicit 参数名:参数类型)
   */
   */

  implicit val str: String = "hello world!"

  def hello(implicit arg: String="good bey world!"): Unit = {
    println(arg)
  }

  implicit  val a=10   //隐式参数

  def add(b:Int)(implicit a:Int)={b+a}

  def main(args: Array[String]): Unit = {
    hello

    println(add(2))
  }
}
