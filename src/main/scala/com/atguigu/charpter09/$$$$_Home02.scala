package com.atguigu.charpter09

import scala.collection.immutable
import scala.io.Source
import scala.util.Try

object $$$$_Home02 {
  /**
   * 获取农产品种类最多的三个省份
   */
  def main(args: Array[String]): Unit = {
    //1:读取数据转换格式
    val list1: List[String] = Source.fromFile("C:\\Users\\Admin\\Desktop\\product.txt", "utf-8").getLines().toList
    println(list1)

    //2:过滤
    val list: List[String] = list1.filter(x => {
      x.split("\t").size == 6  //不完整数据进行过滤
    })

    //3:切割和裁剪字段
    //香菜	2.80	2018/1/1	山西汾阳市晋阳农副产品批发市场	山西	汾阳
    val list2: List[(String, String)] = list.map(x => {
      val arr = x.split("\t")
      val caiName = arr.head //菜的名字
      val province = arr(4) //省份
      (province, caiName)
    })
   // list2.foreach(println(_))

    //4:对相同省份相同菜名进行去重
    val list3: List[(String, String)] = list2.distinct
   // list3.foreach(println(_))

    //5:根据省份分组
    val map: Map[String, List[(String, String)]] = list3.groupBy(x => x._1)
    map.foreach(println(_))

    /**
     * (黑龙江,List((黑龙江,香菜), (黑龙江,绿尖椒), (黑龙江,青椒), (黑龙江,茄子), (黑龙江,西红柿), (黑龙江,黄瓜), (黑龙江,豆角), (黑龙江,西葫芦), (黑龙江,红萝卜), (黑龙江,胡萝卜), (黑龙江,土豆), (黑龙江,白萝卜), (黑龙江,菜花), (黑龙江,大葱), (黑龙江,大蒜), (黑龙江,韭菜), (黑龙江,韭苔), (黑龙江,蒜苗), (黑龙江,生姜), (黑龙江,西兰花), (黑龙江,莴笋), (黑龙江,油麦菜), (黑龙江,西洋芹), (黑龙江,茼蒿), (黑龙江,韭黄), (黑龙江,香椿), (黑龙江,红尖椒), (黑龙江,冬瓜), (黑龙江,南瓜), (黑龙江,苦瓜), (黑龙江,山药), (黑龙江,芋头), (黑龙江,莲藕), (黑龙江,茭白), (黑龙江,平菇), (黑龙江,金针菇), (黑龙江,香菇), (黑龙江,黄豆芽), (黑龙江,大白菜), (黑龙江,小白菜), (黑龙江,油菜), (黑龙江,菠菜), (黑龙江,生菜), (黑龙江,芹菜), (黑龙江,绿豆芽)))
     * (甘肃,List((甘肃,大白菜), (甘肃,油麦菜), (甘肃,茼蒿), (甘肃,生菜), (甘肃,莲藕), (甘肃,绿豆芽), (甘肃,冬瓜), (甘肃,油菜), (甘肃,菠菜), (甘肃,葱头), (甘肃,大蒜), (甘肃,蒜苗), (甘肃,青椒), (甘肃,茄子), (甘肃,西红柿), (甘肃,黄瓜), (甘肃,土豆), (甘肃,生姜), (甘肃,猪肉), (甘肃,牛肉), (甘肃,羊肉), (甘肃,白条鸡), (甘肃,鸡蛋), (甘肃,菜花), (甘肃,大葱), (甘肃,香蕉), (甘肃,西葫芦), (甘肃,黄豆芽), (甘肃,胡萝卜), (甘肃,豆角), (甘肃,蘑菇), (甘肃,青笋), (甘肃,人参果), (甘肃,富士苹果), (甘肃,活鲤鱼), (甘肃,芒果), (甘肃,萝卜), (甘肃,芹菜), (甘肃,莴笋), (甘肃,水萝卜), (甘肃,尖椒), (甘肃,白萝卜), (甘肃,洋白菜), (甘肃,小白菜), (甘肃,香菜), (甘肃,韭菜), (甘肃,木耳), (甘肃,蒜苔), (甘肃,玉米), (甘肃,大豆), (甘肃,菜油)))
     * (四川,List((四川,豇豆), (四川,青冬瓜), (四川,洋白菜), (四川,香菜), (四川,豌豆苗(尖)), (四川,黄豆芽), (四川,绿豆芽), (四川,大白菜), (四川,西红柿), (四川,黄瓜), (四川,青椒), (四川,芹菜), (四川,土豆), (四川,白萝卜), (四川,茄子), (四川,胡萝卜), (四川,韭菜), (四川,南瓜), (四川,蒜苔), (四川,葱头), (四川,生菜), (四川,大蒜), (四川,大葱), (四川,生姜), (四川,莴笋), (四川,丝瓜), (四川,苦瓜), (四川,莲藕), (四川,香菇), (四川,油菜), (四川,菜花), (四川,西兰花), (四川,豆角), (四川,冬瓜), (四川,西葫芦), (四川,平菇), (四川,金针菇), (四川,富士苹果), (四川,红提子), (四川,枇杷), (四川,蜜桔), (四川,核桃), (四川,香蕉), (四川,猪肉), (四川,牛肉), (四川,羊肉), (四川,白条鸡), (四川,活草鱼), (四川,活鲤鱼), (四川,花鲢活鱼), (四川,活鲫鱼), (四川,大带鱼), (四川,大黄花鱼), (四川,大米), (四川,粳米), (四川,籼米), (四川,面粉), (四川,大豆), (四川,菜油), (四川,花生油), (四川,小葱), (四川,鱼腥草(折耳根)), (四川,尖椒), (四川,豌豆), (四川,条形辣椒干（小米椒）), (四川,仔猪), (四川,肥猪), (四川,活鸡), (四川,活鸭), (四川,活鹅), (四川,鸡蛋), (四川,活兔), (四川,山羯羊), (四川,山母羊), (四川,水牛), (四川,黄牛), (四川,绵羊)))
     * (上海,List((上海,大白菜), (上海,洋白菜), (上海,韭菜), (上海,芹菜), (上海,菠菜), (上海,油菜), (上海,菜花), (上海,蒜苗), (上海,生菜), (上海,黄瓜), (上海,豆角), (上海,青椒), (上海,西红柿), (上海,土豆), (上海,红萝卜), (上海,白萝卜), (上海,冬瓜), (上海,南瓜), (上海,莴笋), (上海,西葫芦), (上海,茄子), (上海,葱头), (上海,莲藕), (上海,大葱), (上海,平菇), (上海,香菇), (上海,富士苹果), (上海,鸭梨), (上海,芦柑), (上海,沙糖桔), (上海,香蕉), (上海,猪肉), (上海,牛肉), (上海,白条鸡), (上海,粳米), (上海,面粉), (上海,玉米), (上海,大豆), (上海,豆油)))
     * (青海,List((青海,面粉), (青海,粳米), (青海,玉米)))
     */

    //6:对每个省份的菜种类进行统计
    val map1: Map[String, Int] = map.map(x => {
      val province = x._1
      val size = x._2.size
      (province, size)
    })
    //map1.foreach(println(_))
  println(map1)


    /**
     * (黑龙江,45)
     * (甘肃,51)
     * (四川,77)
     * (上海,39)
     * (青海,3)
     * (浙江,71)
     * (广西,78)
     * (重庆,33)
     * (广东,70)
     * (天津,76)
     * (吉林,47)
     * (北京,169)
     * (山西,106)
     * (辽宁,87)
     * (内蒙古,102)
     * (安徽,114)
     * (江苏,167)
     * (新疆,106)
     * (河南,116)
     * (福建,95)
     * (湖南,58)
     * (河北,99)
     * (湖北,74)
     * (江西,23)
     * (陕西,58)
     * (山东,134)
     * (宁夏,53)
     */
    //7:排序
    val list4: List[(String, Int)] = map1.toList.sortBy(x => x._2).reverse
    list4.foreach(println(_))

    //8:取前三的省份
    println(list4.take(3).map(_._1))
    //List(北京, 江苏, 山东)


    //简化:
    Source.fromFile("C:\\Users\\Admin\\Desktop\\product.txt", "utf-8").getLines().toList
    //过滤
      .filter(x=>{
        x.split("\t").size==6
      })
    //切割和列裁剪
      .map(x=>{
        val arr=x.split("\t")
        val province=arr(4)
        val caiName=arr(0)
        (province,caiName)
      })
      //对相同的省份和相同的菜名去重
      .distinct
      //根据省份分组
      .groupBy(_._1)  //得到是map集合
    //统计菜的种类
      .map(x=>{
        val province=x._1
        val size=x._2.size
        (province,size)
      })
    //对种类进行排序
      .toList.sortBy(_._2).reverse  //因为map没有sortBy排序 所以转化为List
      //取前三
      .take(3).foreach(println(_))

  }
}
