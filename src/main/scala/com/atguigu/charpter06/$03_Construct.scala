package com.atguigu.charpter06

object $03_Construct {
  /**
   * scala中构造器分为两种:
   *     主构造器： 定义在类名后面(),()中可以定义属性，定义属性的语法: [private/..] [val/var] 属性名:属性类型[ = 默认值]
   *         主构造中定义的属性带有val/var与不带val/var的区别：
   *             带有val/var的属性可以在class外部使用[没有private的]
   *             不带val/var的属性只能在class内部使用
   *     辅助构造器：辅助构造器定义在class内部。
   *         语法: def this(参数名: 参数类型,..) = {
   *            在辅助构造器第一行必须调用其他的辅助构造器或者是主构造器
   *         }
   */
  class Person(val name:String,address:String,var age:Int=30){
    def this(age:Int){
      this("bb","beijing",age)
    }

    def this(){
      this("aa","meiguo",55)
      //this(100)
    }

    def this(name:String){
      this()
    }

    def printAddress()=println(s"address=${address}")

  }

  def main(args: Array[String]): Unit = {
    val person=new Person("shenzhen","上海")
    println(person.age)
    println(person.name)
    println(person)

    person.age = 100
    println(person.age)
    println(person.name)
    println(person.printAddress())
    person.printAddress()

    println("1"*100)
    val person1 = new Person
    println(person1.name)
    println(person1.age)
    println(person1.printAddress())

    println("2"*100)
    val person2 = new Person("lisi")
    println(person2.name)
    println(person2.age)
    println(person2.printAddress())


  }
}
