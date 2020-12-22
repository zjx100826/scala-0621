package com.atguigu.charpter09

import scala.reflect.io.File

object $01_ImplicitMethod {
  /**
   * scala中的隐式转换:
   *  1:隐式方法
   *    1:隐式方法就是将一个类型转成另一个类型
   *    2:语法:implicit def 方法名(变量名:待转类型):目标类型={.....}
   *    3:使用时机:
   *       当前类型和目标类型不一致的时候,会自动使用隐式转换
   *       当前类使用了不是自己的方法,也会自动使用隐式转换
   *
   *  2:隐式参数
   *  3:隐式类
   */





  class Person(val name:String,val age:Int)
  class Student(val name:String,val age:Int)

  implicit def studentToPerson(student: Student):Person={
    new Person(student.name,student.age)
  }

  def main(args: Array[String]): Unit = {
    val p:Person=new Student("zhangsan" ,20)
    println(p.name)
    println(p.age)


  }
}
