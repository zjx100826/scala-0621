package com.atguigu.charpter08

object $09_Match {
  /**
   *
   */
  def main(args: Array[String]): Unit = {
    //定义变量的时候使用模式匹配
    val t1=("zhangsan",20,"beijing")
    println(t1._1)

    //val(name,age,address)=("lisi",25,"shenzhen")
    //如果变量不使用可以用_替代
    val(name,_,_)=("lisi",25,"shenzhen")
    println(name)

    val arr=Array(10,20,30)
    println(arr.head)

    val Array(x,_*)= Array(20, 25, 30, 35, 40)
    println(x)

    val Array(a,b,c)=Array(100,200,300)
    println(a,b,c)

    val List(aa,_*)=List("hello",1,2,3)
    println(aa)

    val head :: list=List("wo","ai","ni")
    println(head)
    println(list)
  }
}
