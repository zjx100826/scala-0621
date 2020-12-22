package com.atguigu.charpter04

object $03_For {

  /**
   * * java中for循环：
   * *   1、for(int i=0;i<=10;i++)
   * *   2、for(Person p: list)
   * * scala中的for循环有点类似java的增强for循环
   *
   * to方法  :左右闭合的
   * until  :左闭右开
   *
   * 调用方法的两种方式:
   * 1:对象.方法(参数,...)
   * 2:对象 方法 (参数,..) 如果这有一个参数,()可以省略
   *
   * 语法:for(变量名  <- 数组/集合/表达式)
   *
   * 守卫:就是for循环中添加if条件
   *
   * 循环步长: by(步长数)
   *
   * 嵌套for循环:for(变量名 <-  数组/集合/表达式;变量 <- 数组/集合/表达式;..) { ...}
   *
   * 嵌入变量:for(变量名 <-  数组/集合/表达式;变量名=变量值;变量 <- 数组/集合/表达式;..) { ...}
   *
   * for循环默认没有返回值，要先让for循环有返回值可以使用yield表达式:
   *            for(变量 <- 数组/集合/表达式) yield {....}
   */

  def main(args: Array[String]): Unit = {
    //输出10句 "宋宋，喜欢海狗人参丸"
    for(i <- 1.to(10)){
      println("宋宋，喜欢海狗人参丸")
    }

    //输出1到10中，不等于5的值
    for(a <-1 to 10){
      if(a==5){
        println("进入回收站")
      }else{
        println(a)
      }
    }

    println("*"*100)
    //输出1-10 中间的 2,4,6,8,10
     for(i <- 2.until(11).by(2)){
       println(i)
     }

    //嵌套for循环
    println("*"*100)
    for(x<-1 to 10;y<-1.to(x)){
      println(x*y)
    }

    //嵌套变量循环
    println("*"*100)
    for(x<-1.to(5);z=x*x;y<-1 until(z)){
      println(x*y)
    }

    println("yield"*10)
    //yield
    val result=for(i<-1 to 10)yield{
      val x=i*i
      x
    }
    println(result.toBuffer)

    println("===="*10)
    println((1 to 10).map(x => x * x).toBuffer)



  }

}
