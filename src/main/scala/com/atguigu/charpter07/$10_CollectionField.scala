package com.atguigu.charpter07

object $10_CollectionField {
  def main(args: Array[String]): Unit = {
    val list=List("hello","spark","flume","hive","hadoop")

    //获取集合的长度
    println(list.length)
    println(list.size)

    //判断集合是否为空
    println(list.isEmpty)

    //判断集合是否存在
    println(list.contains("hello"))

    //集合转字符串
    println(list)
    println(list.mkString)

    println(list.toArray.toBuffer)

    println(list.toSet)
  }
}
