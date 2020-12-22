package com.atguigu.charpter09

import scala.io.Source
import scala.util.Try

object $$$$_Home01 {
  /**
   *求哪些省份没有农贸市场
   */
  //1:读取省份的数据,转换格式
  def main(args: Array[String]): Unit = {
    val list: List[String] = Source.fromFile("E:\\0AAAA课件\\scala\\allprovince.txt", "utf-8").getLines().toList
   // println(list)
    /*
    List(山西, 辽宁, 吉林, 黑龙江, 江苏, 浙江, 安徽, 福建, 江西, 山东, 河南, 湖北, 湖南, 广东, 海南, 四川, 贵州, 云南,
           陕西, 甘肃, 青海, 台湾, 内蒙古, 广西, 西藏, 宁夏, 新疆, 香港, 澳门, 河北)
     */

    //2:读取生产市场的数据,转换格式
    val list1: List[String] = Source.fromFile("E:\\0AAAA课件\\scala\\product.txt", "utf-8").getLines().toList
    println(list1)
    //3:切割
    val list2: List[String] = list1.map(x => {
      val arr: Array[String] = x.split("\t")
      val province = Try(arr(4)).getOrElse("")
      province
    })
    println(list2)
    //4:去重
    val distinct: List[String] = list2.distinct
    println("&&&&&&&&&"*5)
    println(distinct)

    /**
     * List(山西, 北京, 山东, 辽宁, 湖南, 四川, , 安徽, 河北, 河南, 江苏, 内蒙古, 陕西, 新疆, 甘肃, 广西, 吉林, 天津, 浙江,
     *                广东, 福建, 湖北, 上海, 江西, 宁夏, 重庆, 青海, 黑龙江)
     */

    //5:求差集
    println(list.diff(distinct))


   //List(海南, 贵州, 云南, 台湾, 西藏, 香港, 澳门)


    //简化:
    Source.fromFile("E:\\0AAAA课件\\scala\\allprovince.txt", "utf-8").getLines().toList
      .diff( Source.fromFile("E:\\0AAAA课件\\scala\\product.txt", "utf-8").getLines().toList
          .map(x=>{
            val arr=x.split("\t")
            val privance=Try(arr(4)).getOrElse("")
            privance
          })
      )


  }
}
