package com.atguigu.charpter04

object $05_Break {


  import scala.util.control.Breaks._


  /**
   * java 中跳出循环的方式:
   * 1:break    结束循环
   * 2:return  连方法都终止了 不怎么采取
   * 3:抛异常
   * 4:continue  结束本次循环,开始下一次循环
   *
   * scala中没有break与contine关键字
   */

  def main(args: Array[String]): Unit = {
//    //break功能
   var i=0
//    breakable({while(i<=10){
//      if(i==5) break();
//      println(i)
//      i+=1
//    }})

    //conntinue功能
    println("+"*100)

    i = 0
    while(i<=10){
      breakable({
        if(i==5) break();
        println(i)
      })
      i = i+1
    }
    
  }
}
