package com.atguigu.fuxi

import scala.collection.immutable
import scala.io.Source
import scala.util.Try

object Home02 {
  /**
   * 获取农产品种类最多的三个省份
   */
  def main(args: Array[String]): Unit = {

    val list: List[String] = Source.fromFile("E:\\0AAAA课件\\scala\\product.txt", "utf-8").getLines().toList
    //香菜	2.80	2018/1/1	山西汾阳市晋阳农副产品批发市场	山西	汾阳

    //对不完整的数据去重
    val list1: List[String] = list.filter(x => {
      x.split("\t") .size== 6
    })

    //获取省份和菜名
    val list2: List[(String, String)] = list1.map(x => {
      val arr: Array[String] = x.split("\t")
      val caiming = arr.head
      val province = Try(arr(4)).getOrElse("")
      ( province,caiming)
    })

    //对菜名进行去重
    val list3: List[(String, String)] = list2.distinct

    //根据省份分组
    val map: Map[String, List[(String, String)]] = list3.groupBy(x => x._1)

    //获取省份和菜品类的个数
    val map1: Map[String, Int] = map.map(x => {
      val province = x._1
      val size = x._2.size
      (province, size)
    })
    println(map1)

    //对菜的品类的个数进行排序
    val list4: List[(String, Int)] = map1.toList
    println(list4)

    val list5: List[(String, Int)] = list4.sortBy(x => x._2).reverse

    val list6: List[(String, Int)] = list5.take(3)
    println(list6.map(x => {
      x._1
    }))





  }
}
