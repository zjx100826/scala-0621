package com.atguigu.charpter05

object $12_Recursion {
  /**
   * 递归:自己调用自己
   *
   * 一个方法必须满足两个条件才是递归方法:
   *  1:递归方法必须有退出条件
   *  2:递归方法必须指定返回值类型
   */

  def main(args: Array[String]): Unit = {
    //案例:5*4*3*2*1
    println(m1(5))

    }
  def m1(x:Int):Int={
    if(x==1){
      1
    }else{
      x * m1(x-1)
    }
  }
}
