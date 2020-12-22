package com.atguigu.charpter05

object $11_ClosePackage {

  /**
   * 函数体中使用了不属于该函数体本身作用域的参数的函数称为闭包
   */
  def main(args: Array[String]): Unit = {
    val a =10
    val func=(x:Int)=>{x+a}
  }
}
