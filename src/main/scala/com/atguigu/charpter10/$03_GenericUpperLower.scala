package com.atguigu.charpter10

object $03_GenericUpperLower {
  /**
   * 上限:
   *   语法: T<类型 [代表T只能是指定的类型或者指定类型的子类]
   * 下限:
   *   语法: T>类型 [代表T只能是指定的类型或者指定类型的父类]
   */
  class Parent

  class Sub1 extends Parent

  class Sub2 extends Sub1

  class Sub3 extends Sub2

  def main(args: Array[String]): Unit = {

    m1(new Sub3)

    m2(new Sub3)  //下限规定不死,因为所有Any是所有类型的父类
  }

  def m1[T<:Sub2](x:T)={println(x)}

  def m2[T>:Sub2](x:T)={println(x)}
}
