package com.atguigu.charpter02

object $2_ParamDefindName {
  /**
   * java 中变量名的命名的规则 :必须是数字.字母,并且首字母不能是数字
   *
   * scala中变量名的命名的规则 :必须是特殊符号,数字.字母,并且首字母不能是数字
   *
   * 虽然scala中可以使用特殊符号进行命名,但是最好不要使用,还是采用java的命名规则,使用驼峰原则
   */

  def main(args: Array[String]): Unit = {
    val name ="zjx"

    val age10=10

    val * = 10

    val $name = "lisi"

    println(*)

    print($name)
  }
}
