package com.atguigu.charpter05

object $10_Currying {
  /**
   * 柯里化:  有多个参数列表的方法称之为柯里化
   * 柯里化是必然产物，因为函数是对象，定义方法，返回一个函数
   */
  def main(args: Array[String]): Unit = {
    println(add2(10, 20)(30, 40)(100))
//    val func1 = add3(10,20)
//
//    val func2 = func1(30,40)

//    val result = func2(100)
//
//    val add = add3 _
//    println(add3(10, 20)(30, 40)(100))
    
//    println(result)
  }

  def add1(x:Int,y:Int)={x+y}

  def add2(x:Int,y:Int)(a:Int,b:Int)(z:Int)=x+y+a+b+z

  def add3(x:Int,y:Int)={
    val func1=(a:Int,b:Int)=>{
      val func2=(z:Int)=>x+y+a+b+z
      func2
    }
    func1
  }

}
