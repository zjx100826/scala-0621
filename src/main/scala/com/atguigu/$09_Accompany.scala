package com.atguigu

object $09_Accompany {

  /**
   * 伴生对象与伴生类
   * 1、class与object在同一个.scala文件中
   * 2、class与object的名称要一样
   * 特性:
   * 1、伴生类与伴生对象可以互相访问私有成员
   * 2、伴生对象的apply方法[简化伴生类的对象创建]
   */
  def main(args: Array[String]): Unit = {
    val person = new Person("shenzhen", "nan")
    println(person.name)
    println(person.sum(2, 3))

    println(Person.param)
    println(Person.printAge)

    val person1 = Person.apply("beijing", "nan")
    println(person1.name)
    println(person1.address)
    val person2 = Person("WANGWU", "NV")



  }
}
  //伴生类[非静态的]
  class Person(val address:String, val sex:String){
    val name:String="lisi"

    private val age=20
    //访问伴生对象的私有方法
    def sum(x:Int,y:Int)=Person.add(x:Int,y:Int)
  }

  //伴生对象[静态的]
  object Person{
    val param="200"

    private def add(x:Int,y:Int)={x+y}
    //伴生对象访问伴生类的私有成员[访问的时候必须要有伴生类的对象]
    def printAge= println(s"age=${new Person("shenzhen", "nan").age}")

    //简化伴生类的对象的创建
    def apply(name:String,sex:String)=new Person(name,sex)

  }

