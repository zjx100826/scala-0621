package com.atguigu.charpter06

object $02_DefindFieldAndMethod {

  class Person {
    //scala 中定义属性和方法
    //语法:[private/protect/default]属性名:属性的类型=属性值
    val name: String = "zhangsan" //[scala中必须赋值]

    var age = 20
    //在class中可以通过_对var定义的变量进行初始化，在定义变量的时候必须定义变量类型
    var address: String = _ //[String类型默认是null] 还必须指明默认值的类型,否则报错
    var sex:Char=_

    //scala中定义方法
    //语法:[private/protect/default]def 方法名(参数名:参数类型,...):返回值类型={方法体}
    def add(x:Int,y:Int)={x+y}
    //方法的重载
    def add(x:Int)={x+10}

    //定义函数
    val func=(msg:String)=>{println(s"hello${msg}")}
  }

  def main(args: Array[String]): Unit = {
   val person= new Person
    //给age重新赋值,会覆盖掉原先的默认值
    person.age=100
    println(person.age)

    //println(person.aa)

    println(person.address)

    //调用方法
    println("*"*100)
    println(person.add(2, 3))

    //调用函数
    println(person.func("zhenzhen"))

    println("@@"*50)
    println(person.sex)

  }

}
