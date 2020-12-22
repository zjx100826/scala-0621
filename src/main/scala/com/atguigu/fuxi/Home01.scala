package com.atguigu.fuxi

import scala.io.Source
import scala.util.Try

object Home01 {
  /**
   *求哪些省份没有农贸市场
   */
  def main(args: Array[String]): Unit = {
  val list: List[String] = Source.fromFile("E:\\0AAAA课件\\scala\\allprovince.txt", "utf-8").getLines().toList
    println(list)

    val list1: List[String] = Source.fromFile("E:\\0AAAA课件\\scala\\product.txt", "utf-8").getLines().toList
    val list2: List[String] = list1.map(x => {
      val arr: Array[String] = x.split("\t")
      Try(arr(4)).getOrElse("")
    })

    println(list.diff(list2.distinct))
  }


}
