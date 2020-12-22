package com.atguigu.charpter06

import scala.util.Random

object $14_TypeCheck {
  /**
   * java中判断类型 对象instanceof B
   * java中的强转: (类型)对象
   * scala中判断对象:对象.isInatanceOf[类名]
   * scala中的强转:对象.asInstanceOf[类名]
   *
   * *
   * * java获取对象的class形式: 对象.getClass
   * * scala获取对象的class形式: 对象.getClass
   * *
   * * java中获取类的class形式： 类名.class
   * * scala中获取类的class形式： classOf[类名]
   */
  class Animal{
    def hello()={println("Animal...........")}
  }

  class Pig extends Animal {
    val age=20
    override def hello(): Unit = println("Pig...............")
  }

  class Dog extends Animal{
    val name:String="dog"
    override def hello(): Unit = println("dog.......")
  }

  class AA{
    def getAnimal()={
      val n = Random.nextInt(10)
      if(n%2==0){
        new Dog
      }else{new Pig}
    }
  }

  def main(args: Array[String]): Unit = {
    val aa = new AA
    val animal = aa.getAnimal()
    if(animal.isInstanceOf[Dog]){
      val dog = animal.asInstanceOf[Dog]
      println(dog.name)
      dog.hello()

    }else{
      val pig = animal.asInstanceOf[Pig]
      println(pig.age)
        pig.hello()
    }
    println(animal.getClass)
    println(classOf[Dog])
  }
}
