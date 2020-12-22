package com.atguigu.charpter07

object $05_ImmutableSet {
  /**
   * Set的特点:无序,不重复
   */
  def main(args: Array[String]): Unit = {
    //创建
    val set = Set[Int](2, 4, 6, 8, 10)
    println(set)

    //添加元素
    val set1 = set.+(12)
    println(set1)

    val set2 = set.++(Set(20, 30))
    println(set2)

    //删除数据
    println(" //删除数据"*20)
    val set3 = set.-(30)
    println(set3)

    val set4 = set.--(set1)
    println(set4)

     //遍历
    for(i<-set){
      println(i)
    }
  }
}
