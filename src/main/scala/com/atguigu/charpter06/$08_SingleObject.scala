package com.atguigu.charpter06

object $08_SingleObject {
  val name = "zhangsan"

  val func = (x:Int) => x*x

  def add(x:Int,y:Int) = x+y

  /**
   * 单例对象：
   *   语法:  object object名称
   * scala object中所有的属性/方法/函数都是类似java static标识的
   * 调用的是就可以通过 object名称.属性/方法/函数
   *
   */
  def main(args: Array[String]): Unit = {
    println($08_SingleObject)
    println($08_SingleObject)

    println($08_SingleObject.name)
    println($08_SingleObject.func(5))
    println($08_SingleObject.add(5,6))
  }
}
