package com.atguigu.charpter10

object $02_GenericClass {
  /**
   * 泛型类:
   *  class   类名 [泛型1,泛型2,..](var 属性名:泛型,..){}
   */
  def main(args: Array[String]): Unit = {

    val person = new Person[String, Int]("zhangsan", 30)
    println(person.getName)
    println(person.getAge())
  }

  class Person[T,U](var name:T,var age:U){

    def getName() = this.name

    def setName(name:T) = {
      this.name=name
    }

    def getAge() = this.age

    def setAge(age:U) = this.age = age


  }
}
