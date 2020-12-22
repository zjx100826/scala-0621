package com.atguigu.charpter08

object $08_MatchClass {
  /**
   *样例类:
   *   语 法 :case class 类名([val /var] 属性名1:属性类型1,.....)
   *   创建样例类的时候属性可以不写val或者var 以及默认使用了val
   *   创建样例列对象: 类名(参数,....)
   *
   * 样例对象
   *   语法:case object 名称[跟样例类的类名一样]
   *   在源码侧面,一般用样例对象做枚举值
   *
   *   如果想让普通类使用模式匹配,需要创建伴生对象,并且在伴生对象中定义unapply方法,将对象的属性提出来
   */

  //创建样例类:
  case class Person(name:String, age:Int)

  //创建普通类:
  class Animal(var name:String, var sex:String)
  //普通类的伴生对象
  object Animal {
    def unapply(arg: Animal): Option[(String, String)] = {
      if(arg==null)
        None
      else{
        Some((arg.name,arg.sex))
      }
    }

  }

  def main(args: Array[String]): Unit = {
    val person = Person("zjx", 24)
    println(person.name)
    println(person.age)

    val animal = new Animal("熊猫", "公的")

    println("*"*100)
    person match {
      case Person(name,age) =>println(s"${name}  ${age}")
    }

    println("%%"*50)
    animal match {
      case Animal(name,sex)=>println(s"${name} ${sex}")
    }

  }
}
