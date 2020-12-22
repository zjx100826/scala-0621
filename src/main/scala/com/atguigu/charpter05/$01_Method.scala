package com.atguigu.charpter05

object $01_Method {
  /**
   * 方法定义的语法:
   * def 方法名(参数名:参数类型,....):返回值类型={方法体}
   */
  def main(args: Array[String]): Unit = {
    def add(x:Int,y:Int):Int={
      return x+y
    }

    println(add(2, 3))
  }

}
