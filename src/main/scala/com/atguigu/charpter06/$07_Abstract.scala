package com.atguigu.charpter06

object $07_Abstract {

  abstract class Animal {
    //抽象方法是没有方法体的方法
    def add(x: Int, y: Int):Int

    //没有属性值的属性是抽象属性
    val age: Int
  }
    class Dog extends Animal{
      //重写抽象方法
      override def add(x: Int, y: Int): Int = x+y
       //重写抽象属性
      override val age: Int = 13
    }

    /**
     * 抽象类:
     *     定义:  abstract class 类名{..}
     * 抽象类中既可以定义抽象方法也可以定义具体方法
     * 抽象类中既可以定义抽象字段也可以定义具体字段
     */

    def main(args: Array[String]): Unit = {
      val dog = new Dog
      println(dog.age)
      println(dog.add(1, 2))
      println("%%"*50)

      //匿名子类
     val animal= new Animal {
        override def add(x: Int, y: Int): Int = x*y

        override val age: Int = 20
      }
      println(animal.age)
      println(animal.add(2, 3))
    }

}
