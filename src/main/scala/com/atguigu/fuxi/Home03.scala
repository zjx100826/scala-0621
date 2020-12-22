package com.atguigu.fuxi

import scala.io.Source

object Home03 {
  //求每个省份农产品最多的三个市场
  def main(args: Array[String]): Unit = {
    val list: List[String] = Source.fromFile("E:\\0AAAA课件\\scala\\product.txt", "utf-8").getLines().toList

    //过滤掉不完整的数据
    val list1: List[String] = list.filter(x => {
      x.split("\t").size == 6
    })

    //对数据进行切割
    val list2: List[(String, String, String)] = list1.map(x => {
      val arr: Array[String] = x.split("\t")
      //香菜	2.80	2018/1/1	山西汾阳市晋阳农副产品批发市场	山西	汾阳
      val province = arr(4)
      val supmaket = arr(3)
      val caiName = arr.head
      (province, supmaket, caiName)
    })

    //去重
    val list3: List[(String, String, String)] = list2.distinct

    //根据相同的省份和市场进行分组
    val map: Map[(String, String), List[(String, String, String)]] = list3.groupBy(x => {
      (x._1, x._2)
    })

   // map.foreach(println(_))

    //统计
    val map1: Map[(String, String), Int] = map.map(x => {
      val provinceSupmaket = x._1
      val size = x._2.size
      (provinceSupmaket, size)
    })
    //map1.foreach(println(_))

    val map2: List[((String, String), Int)] = map1.toList.sortBy(x => x._2).reverse

    map2.map(x=>{
      val supmaket=x._1._2
      val size=x._2
      (supmaket,size)
    }).take(3).foreach(println(_))

    /**
     * (江苏凌家塘农副产品批发市场,146)
     * (河南郑州农产品物流配送中心,114)
     * (北京八里桥农产品中心批发市场,112)
     */


  }
}
