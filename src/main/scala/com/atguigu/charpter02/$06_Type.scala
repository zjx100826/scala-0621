package com.atguigu.charpter02

object $06_Type {
  /**
   * java de 数据类型:
   *   基本数据类型有:byte short int long float double char boolean
   *   引用数据类型:String 集合 包装类 自定义类型 class ...
   *
   * scala是完全面向对象的
   *   Any是所有类的父类,如同java的Object
   *   AnyVal:值类型
   *      Int、Byte、Short、Long、Float、Double、Char、Boolean
   *   StringOps:是对java String的扩展
   *
   * AnyRef: 引用类型
   *      String、java/scala class、java/scala集合,..
   *   Null: 是所有引用类型的子类，有一个实例null。所以一般会将null作为初始值赋值为引用类型,
   *             在使用null作为初始值的时候，必须指定变量的类型，不能使用自动推断
   *
   *    Nothing: 所有类型的子类。没办法直接实例化，一般是scala报错使用
   */
  def main(args: Array[String]): Unit = {
    val a :Unit =()
    println(a)

    println("="*100)

    val name :String=null
    println(name)

    val age:String=null

    println(age)

    var str1 : String = true + ""
    println(str1)


  }

}
