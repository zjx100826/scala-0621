package com.atguigu.charpter05

object $04_FunctionAndMethod {

  def main(args: Array[String]): Unit = {
    /**
     * 方法和函数的区别：
     *   1、加载时间不一样: 函数是对象，定义在哪里就在哪里加载，方法是随着类的加载而加载
     *         方法可以先调用后定义也可以先定义后调用
     *         函数只能先定义后调用
     *   2、方法可以重载，函数不可以
     *   3、方法是保存在方法区，函数是保存在堆
     *
     * 如果方法定义在方法里面，就是相当于是函数
     * 方法可以转成函数： 方法名 _
     */
      //先调用后定义
    //println(func(2, 3))  报错
    val func =(x :Int,y:Int)=>x+y
    //先定义后调用,正常使用
       println(func(2, 3))


    // 如果方法定义在方法里面，就是相当于是函数
    // 方法可以转成函数： 方法名 _
    def add(x:Int,y:Int) = x+y
    val func1= add _
    println(func1(10, 20))


  }
  //方法的重载[1同一个类中 2方法名相同 3参数列表不同(顺序,个数....)]
  println("%%$$"*30)
  def m1(x:Int)=x*x
  def m1(x:Int,y:Int)=x*y

  println(m1(2, 4))

  //验证函数不可以重载[因为函数名相同报错]
//  val m2=(x:Int)=>x*x
//  val m2=(x:Int,y:Double)=>x*y
}
