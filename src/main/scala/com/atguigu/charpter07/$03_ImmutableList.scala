package com.atguigu.charpter07

object $03_ImmutableList {
  /**
   * 创建:
   *   1、List[元素类型](初始元素,...)
   *   2、Nil  空集合
   *   :: 与 :::的区别
   *      :: 是添加单个元素 [添加到最前面]
   *      ::: 是添加一个集合的所有元素[添加到最前面]
   */
  def main(args: Array[String]): Unit = {
    //创建
    val list = List[Int](1, 2, 3, 4, 5)
    println(list)

    //添加元素
    println("//添加元素"*10)
    val list1 = list.+:(0)
    println(list1)

    val list2 = list.:+(6)
    println(list2)

    val list3 = list.++(List(10, 20))
    println(list3)

    val list4 = list.++:(List(100, 2000))
    println(list4)

    println("&"*100)
   println(list)
    val list5 = 100 :: list
    println(list5)

    val list6 = 200 :: 300 :: 400 :: list
    println(list6)

    println(":::/"*20)
    val list7 = list2 ::: list
    println(list7)

    //查询数据
      //list7 数据  List(1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5)
      val list8 = list7(2)
    println(list8)

    //修改数据
    val list9 = list7.updated(0, 1000)
    println("list9="+list9)
    var list10:List[Int] = Nil


//    //遍历
//    for(i<-list9){println(i)}
 }


}
