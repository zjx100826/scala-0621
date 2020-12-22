package com.atguigu.charpter06

object $05_Extends {

  class Person{
    val name:String="lisi"
    var age:Int= 15
    private  val address:String="shenzhen"
    def add(x:Int,y:Int)={x+y}
  }

  class Student extends Person{
     override  val name:String="zhangsan"
    //override var age=14   //override只能重写父类属性的时候只能重写val标识的属性

    //重写方法
   override def add(x: Int, y: Int): Int = x*y

    //子类通过super调用父类的方法
    super.add(5,4)
  }

  /**
   *子类继承父类:
   * 1:父类中被final修饰的属性个方法不能被继承
   * 2:父类中被private修饰的属性个方法不能被继承
   * 3:子类继承父类必须用override关键字来重写父类的属性/方法/函数
   */
  def main(args: Array[String]): Unit = {
    val p:Person = new Student
    val student:Student = new Student

    println(p.name)
    println(student.name)
    println(student.age)


    println(p.add(2, 4))
    println(p)
  }
}
