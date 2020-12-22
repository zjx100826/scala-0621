package com.atguigu.charpter06

import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}

object $13_SelfObject {

  /**
   *需求:编写一个特质,后续class继承该特质后,能够将自己写入磁盘
   *
   *  自类型:
   *   在trait中通过this:类型=> 表示后续子类继承该trait必须实现/继承指定类型
   */


    trait ReadAndWrite {
      this:Serializable=>

    def write() = {
      //对象写入流
      val oos = new ObjectOutputStream(new FileOutputStream("e:/a.txt"))
      //写入对象
      oos.writeObject(this)
      oos.flush()
      oos.close()
    }

    def read() = {
      //对象输出流
      val ois = new ObjectInputStream(new FileInputStream("e:/a.txt"))
      val value = ois.readObject()
      ois.close()
      value
    }
  }

  class Person(val name:String,val age:Int)extends ReadAndWrite with Serializable {}

  def main(args: Array[String]): Unit = {
    val person = new Person("lisi", 20)
    person.write()

    val person1 = new Person("xijinping", 56)
    val person2 = person1.asInstanceOf[Person]
    println(person2.name)
    println(person2.age)
  }


}
