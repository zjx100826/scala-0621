package com.atguigu.charpter05

object $13_Lazy {
  /**
   * 懒值加载:
   *  通过Lazy标识的变量不会立即初始化,只有在真正使用的时候才会被初始化
   *
   *  lazy加载能够节省内存空间
   *
   */
  def main(args: Array[String]): Unit = {
    val name="zhangsan"
    println(name)

    lazy val age =12
    //rintln(age)

  }
}
