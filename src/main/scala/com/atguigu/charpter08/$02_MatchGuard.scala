package com.atguigu.charpter08

import scala.io.StdIn

object $02_MatchGuard {
  /**
   * 模式守卫
   * 语法:变量 match{
   *    case .. if(布尔表达式) =>{执行体}
   *    case ..
   *  }
   *  模式匹配有返回值,就是{}中的结果值  [最后一行代表其返回值]
   */
  def main(args: Array[String]): Unit = {
    val lines=StdIn.readLine("请输入一个字母:")
    val a=lines match {
      case x if(x.startsWith("ha")) =>{
        println(x+"该字母是以ha开头的")
        1
      }

      case x if(x.startsWith("ka")) =>println(x+"该字母是以ka开头的")
      case x if(x.startsWith("he")) =>println(x+"该字母是以he开头的")
      case _ =>println("其他,不在这个范围")
    }

    println(a)
  }
}
