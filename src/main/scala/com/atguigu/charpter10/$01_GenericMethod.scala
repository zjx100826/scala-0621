package com.atguigu.charpter10

object $01_GenericMethod {
  /**
   * 泛型方法:
   *    定义: def 方法名[T,U...](参数名:参数类型T,...):返回值类型U={..}
   */
  def main(args: Array[String]): Unit = {
println(add[Int](3,5))

  }

def add[T](x:T,y:T):T={x}
}
