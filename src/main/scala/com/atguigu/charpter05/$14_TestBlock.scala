package com.atguigu.charpter05

object $14_TestBlock {

  def loop(n: Int)(op: => Unit): Unit = {
    if (n > 0) {
      op
      loop(n - 1)(op)
    }
  }

  def main(args: Array[String]): Unit = {

    loop(5) {
      println("test")
    }
  }
}
