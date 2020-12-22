package com.atguigu.charpter09

import scala.collection.immutable
import scala.io.Source

object $$$$_Home03 {
//  需求::3、获取每个省份农产品最多的三个农贸市场
def main(args: Array[String]): Unit = {
  //1:读取数据和转换格式
  val list: List[String] = Source.fromFile("C:\\Users\\Admin\\Desktop\\product.txt", "utf-8").getLines().toList
  //2:过滤不完整的数据
  val list1: List[String] = list.filter(x => x.split("\t").size == 6)
  //3:切割和裁剪字段
     ////香菜	2.80	2018/1/1	山西汾阳市晋阳农副产品批发市场	山西	汾阳
     val list2: List[(String, String, String)] = list1.map(x => {
       val arr = x.split("\t")
       val province = arr(4)
       val supmaket = arr(3)
       val caiName = arr.head
       (province, supmaket, caiName)
     }).distinct   //对相同的省份和相同的市场及相同的菜名进行去重
  //list2.foreach(println(_))

  /**  部分数据
   * (山西,山西汾阳市晋阳农副产品批发市场,香菜)
   * (山西,山西汾阳市晋阳农副产品批发市场,大葱)
   * (山西,山西汾阳市晋阳农副产品批发市场,葱头)
   * (山西,山西汾阳市晋阳农副产品批发市场,大蒜)
   * (山西,山西汾阳市晋阳农副产品批发市场,蒜苔)
   * (山西,山西汾阳市晋阳农副产品批发市场,韭菜)
   * (山西,山西汾阳市晋阳农副产品批发市场,青椒)
   * (山西,山西汾阳市晋阳农副产品批发市场,茄子)
   * (山西,山西汾阳市晋阳农副产品批发市场,西红柿)
   * (山西,山西汾阳市晋阳农副产品批发市场,黄瓜)
   * (山西,山西汾阳市晋阳农副产品批发市场,青冬)
   * (山西,山西汾阳市晋阳农副产品批发市场,西葫芦)
   * (山西,山西汾阳市晋阳农副产品批发市场,白萝卜)
   * (山西,山西汾阳市晋阳农副产品批发市场,胡萝卜)
   * (山西,山西汾阳市晋阳农副产品批发市场,土豆)
   * (山西,山西汾阳市晋阳农副产品批发市场,豆角)
   * (山西,山西汾阳市晋阳农副产品批发市场,尖椒)
   * (山西,山西汾阳市晋阳农副产品批发市场,面粉)
   * (山西,山西汾阳市晋阳农副产品批发市场,大米)
   * (山西,山西汾阳市晋阳农副产品批发市场,豆油)
   * (山西,山西汾阳市晋阳农副产品批发市场,富士苹果)
   * (山西,山西汾阳市晋阳农副产品批发市场,香蕉)
   * (山西,山西汾阳市晋阳农副产品批发市场,鸡蛋)
   * (山西,山西汾阳市晋阳农副产品批发市场,猪肉)
   * (山西,山西汾阳市晋阳农副产品批发市场,牛肉)
   * (山西,山西汾阳市晋阳农副产品批发市场,大白菜)
   * (山西,山西汾阳市晋阳农副产品批发市场,油菜)
   * (山西,山西汾阳市晋阳农副产品批发市场,菠菜)
   * (山西,山西汾阳市晋阳农副产品批发市场,菜花)
   * (山西,山西汾阳市晋阳农副产品批发市场,生菜)
   * (山西,山西汾阳市晋阳农副产品批发市场,芹菜)
   */
  //4:根据省份和市场分组
  val map: Map[(String, String), List[(String, String, String)]] = list2.groupBy(x => {
    (x._1, x._2) //多重分组用()扩起来,用,分割
  })
  map.foreach(println(_))
  //((天津,天津西青区当城无公害农副产品批发市场),List((天津,天津西青区当城无公害农副产品批发市场,芹菜), (天津,天津西青区当城无公害农副产品批发市场,香菜),....

  //5:统计
  val map1: Map[(String, String), Int] = map.map(x => {
    val provinceAndSupmaket = x._1
    val size = x._2.size
    (provinceAndSupmaket, size)
  })
 // map1.foreach(println(_))
  /**     部分数据
   * ((安徽,安徽砀山农产品中心惠丰批发市场),52)
   * ((广西,广西南宁市五里亭蔬菜批发市场),47)
   * ((北京,北京八里桥农产品中心批发市场),112)
   * ((湖南,长沙市马王堆批发市场),56)
   * ((黑龙江,黑龙江鹤岗市万圃源蔬菜有限责任公司),45)
   * ((河北,河北怀来县就西果菜批发市场有限责任公司),34)
   * ((安徽,安徽马鞍山安民农副产品批发交易市场),62)
   * ((陕西,陕西西部欣桥农产品物流中心),25)
   */


  //6:排序求前三
  val list3: List[((String, String), Int)] = map1.toList.sortBy(_._2).reverse
  list3.take(3).foreach(println(_))
  //((江苏,江苏凌家塘农副产品批发市场),146)
  //((河南,河南郑州农产品物流配送中心),114)
  //((北京,北京八里桥农产品中心批发市场),112)


  list3.map(x=>{
    val supmaket=x._1._2
    val size=x._2
    (supmaket,size)
  }).take(3).foreach(println(_))

  /**
   * (江苏凌家塘农副产品批发市场,146)
   * (河南郑州农产品物流配送中心,114)
   * (北京八里桥农产品中心批发市场,112)
   */




//  //简化:
//    //读取数据和转换格式
//  Source.fromFile("C:\\Users\\Admin\\Desktop\\product.txt", "utf-8").getLines().toList
//   //过滤
//    .filter(_.split("\t").size==6)
//  //切割和裁剪字段
//    .map(x=> {
//      val arr = x.split("\t")
//      val province=arr(4)
//      val supmaket=arr(3)
//      val caiName=arr.head
//      (province,supmaket,caiName)
//    })
//  //去重
//    .distinct
//  //对省份和市场进行分组
//    .groupBy(x=>(x._1,x._2))
//  //统计
//    .map(x=>{
//      val provinceAndSupmaket=x._1
//      val size=x._2.size
//      (provinceAndSupmaket,size)
//    })
//  //排序[转List]
//    .toList.sortBy(_._2).reverse
// //求前三和遍历
//    .take(3).foreach(println(_))
}
}
