package com.atguigu.charpter06

object $11_TraitObjectMixIn {
  /**
   * 对象混入:让某个对象拥有特质的属性/方法/函数
   * 语法:new 类名 with特质名
   */
  trait Log{
    val age=18
    val name="xijinping"
    def add(x:Int,y:Int):Int={x+y}
  }

  class Error{}

  def main(args: Array[String]): Unit = {
    val error = new Error with Log
    println(error.add(2, 3))
    println(error.age)
    println(error.name)
  }
}
