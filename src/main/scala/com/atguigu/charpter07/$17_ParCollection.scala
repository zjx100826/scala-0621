package com.atguigu.charpter07

object $17_ParCollection {
  //并行集合
  def main(args: Array[String]): Unit = {
    val list = List[String]("hi", "ou", "iie", "jelkd")
    list.foreach(x=>{
      println(x)
      println(Thread.currentThread().getName)
    })

    println("**"*20)
    list.par.foreach(x=>{
      println(x)
      println(Thread.currentThread().getName)
    })
  }
}
