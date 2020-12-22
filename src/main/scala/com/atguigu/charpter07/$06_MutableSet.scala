package com.atguigu.charpter07
import scala.collection.mutable
object $06_MutableSet {
  def main(args: Array[String]): Unit = {
    //创建
    val set = mutable.Set[Int](1, 2, 3, 4, 5,5)
    println(set)

    //添加数据
    val set1 = set.+=(5)
    println(set1)

    val set2 = set.++=(set1)
    println(set2)

    //删除数据
    println("删除数据//"*20)
    println("set="+set)
    val set3 = set.-(5)
    println(set3)

    //true为添加数据  false为删除数据
    val set5 = set.update(10, true)
    println(set5)

    val set6 = set.update(2, false)

    set.update(100,true)
    println(set)

  }
}
