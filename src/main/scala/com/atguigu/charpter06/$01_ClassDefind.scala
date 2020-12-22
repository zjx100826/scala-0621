package com.atguigu.charpter06

object $01_ClassDefind {

  //如果class中没有定义什么东西.{}可以省略
  class Person{}
  class Person1


  /**
   * java中创建class
   *  public class 类名{....}  public 缺省的 protect private
   *
   *  scala中没有class,默认就是public效果
   *  class 类名{..}
   */
  def main(args: Array[String]): Unit = {
    //创建person对象,如果使用的是默认构造器,()可以省略
    val person=new Person()
    val person1=new Person
    println(person)

  }
}
