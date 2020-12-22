package com.atguigu.charpter07

object $11_CollectionMethod {
  def main(args: Array[String]): Unit = {
    val list = List("hadoop","hadoop","spark","flume","kafka")
    //去重[job的效率[过滤、列裁剪、去重]] ****
    println(list.distinct)

    //删除前多少个元素,保留之后的元素 ***
    println("//删除前多少个元素,保留之后的元素 ***")
    println(list.drop(3))

    //删除后多少个元素
    println("//删除后多少个元素")
    println(list.dropRight(1))

    //获取第一个元素 ****
    println("//获取第一个元素 ****")
    val head = list.head
    println(head)

    //获取最后一个元素 ***
    println("//获取最后一个元素 ***")
    val last = list.last
    println(last)
    val i = list.lastIndexOf("spark":String) //索引位置
    println(i)

    //获取除开最后一个元素的所有元素
    println(list.init)

    //反转
    println("反转")
    val list6 = list.reverse
    println(list6)


    //获取除开第一个元素的所有元素 ***
    val list7 = list.tail
    println("获取除开第一个元素的所有元素:"+list7)

    //获取前多少个元素 ****
    val list9 = list.take(3)
    println("获取前3个元素:"+list9)

    //获取后多少个元素
    val list10 = list.takeRight(2)
    println("获取后2个元素:"+list10)

    //拉链
    val words=List("aa","bb","cc")
    val count=List(10,20,30)
    val list11 = words.zip(count)
    println("拉链:"+list11)

    //反拉链
    val unzip = list11.unzip
    println("反拉链:"+unzip)

    //交集【两个集合都存在的元素】
    val word1=List(1,2,3,4,5,6,7)
    val word2=List(2,3,4,6,8)
    val list1 = word1.intersect(word2)
    println("交集【两个集合都存在的元素】:"+list1)

    //差集 [A 差 B 取得A中有B中没有的元素]
    val list2 = word1.diff(word2)
    println("差集 [A 差 B 取得A中有B中没有的元素]:"+list2)

    //并集【合并两个元素，不会去重】
    val list3 = word1.union(word2)
    println("并集【合并两个元素，不会去重】:"+list3)

    //获取子集合  [左开右闭]
    val list4 = word1.slice(2, 4)
    println("获取子集合:"+list4)
    //窗口
    //sliding(窗口的大小,滑动的长度)  ****
    println(list)
    val list15 = list.sliding(2, 2)
    println(list15.toBuffer)
  }
}
