package com.atguigu.charpter06

object $06_Package {
  /**
   * scala 包的作用:
   * 1:管理类
   * 2:便于同名类的区分
   * 3:类的访问权限的控制[scala才有] [private[包名]]
   *
   * 包的命名规范:包必须是字母,数字.下划线,小圆点组成,一般都是字母和小圆点
   * 工作中的包命名:com.项目名.业务线.模块
   */

  /**
   * java包的使用:
   * 1声明包:必须在源文件的第一行通过package包名...
   * 2导入包:必须在class前面通过import包名
   *    导入方式:
   *    其一:导入包下的所有类: import 包名.*
   *    其二:导入包下的某个类:import 包名.类名
   */

 /**
  *  *   2、导入包
  *     scala可以在任何地方导入包,需要注意作用域的问题，在某一个作用域导入的包只能在该作用域或者其子作用域中才能使用
  *     1、导入包下的所有类: import 包名._
  *     2、导入包下某个类: import 包名.类名
  *     3、一次导入包下多个类: import 包名.{类名1,类名2}
  *     4、导入包下类的同时给类起别名: import 包名.{类名=> 别名}
  *     5、导入包下除开某个类的所有类: import 包名.{类名=>_ ,_}
  *   3、包对象
  *     语法: package object 对象名称
  *     包对象中定义的非私有的所有的属性和方法/函数在包下所有地方都可以直接使用
    *     包对象中定义的非私有的所有的属性和方法/函数只能在当前包下使用，子包也不可以使用
  */

   def main(args: Array[String]): Unit = {

    import java.util.{HashMap=>JavaHashMap,_}


    import scala.collection.mutable.{HashMap=>ScalaHashMap,ListBuffer}
    val map = new JavaHashMap[String,String]()

    def m1() = {
      new JavaHashMap[String,String]()
    }

  }

}

/**

 * 此种声明方式相当于是在当前包下再创建了一个包，该包在项目结构下直接看不到，在target目录才能看到
 */
package demo{

  class Person
}


