package com.atguigu.charpter07

import scala.collection.mutable.ListBuffer

object $04_MutableList {

  //创建：ListBuffer[元素类型](初始元素,...)
  def main(args: Array[String]): Unit = {
    //创建
    val list = ListBuffer[Int](1, 2, 3, 4, 5)
    println(list)
    //添加数据
    val list1 = list.+:(0)
    println(list1)

    val list2 = list.:+(6)
    println(list2)

    val list3 = list.+=(7)
    println(list3)

    val list4 = list.+=:(10)
    println(list4)
    println(list)

    //删除元素  list 数据 ListBuffer(10, 1, 2, 3, 4, 5, 7)
    val list5 = list.-=(7)
    println(list5)

    val list6 = list.--=(list1)
    println("list6="+list6)
    println(list)

    //查询数据
    val list7 = list(0)
    println(list7)

    //修改数据
    list(0)=1000
    println(list)
  }
}
