package com.atguigu.charpter01

import java.util

object HelloWord {

  /**
   * java 中 public static void main(Stirng [] args){....}
   *   main 方法定义在static的静态中
   *
   * scala中没有static,方式object定义的所有方法和属性都是静态的
   * scala中的class中定义的属性和方法都是非静态的
   * 所以scala 的main 方法必须选用object
   *
   * scala中没有public关键字,默认就是
   * Unit相当于java中的 viod 无返回值
   * scala中的数组用Array表示,Array的数据类型用泛型表示.用的是[],java中用的是<>
   *def 是defined 的缩写,一般声明的是方法
   */

  def main(args: Array[String]): Unit = {
    println("Hello Word")
  }

      val list=new util.ArrayList[Integer]()
      list.add(10)
      list.add(20)
      list.add(30)
      println(list)

}
