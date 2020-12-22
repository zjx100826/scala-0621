package com.atguigu.charpter05

object $03_FunctionDefind {
  /**
   * 函数的语法: val 函数名=(参数名 :参数类型,....)=>{函数体}
   * 函数的返回值就是函数体表达式的结果值
   *
   * 函数的调用的时候,必须带上()
   *
   * 如果函数体只有一行语句,{}可以省略
   */
  def main(args: Array[String]): Unit = {
    val func=(x:Int,y:Int)=>{x+y}  //如果函数体只有一行语句,{}可以省略
    //调用函数
    println(func(2, 4))
  }
  val func1 = () => println("++++++++++")
  func1()

}
