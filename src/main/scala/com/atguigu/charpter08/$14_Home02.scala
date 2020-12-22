package com.atguigu.charpter08

import java.text.SimpleDateFormat

import scala.collection.immutable
import scala.io.Source

object $14_Home02 {
//需求,每个区域的平均等客时间
def main(args: Array[String]): Unit = {
  /**
   * A   龙华区   宝安区   2020-07-15 10:05:10   2020-07-15 10:25:02
   * B   宝安区   福田区   2020-07-15 11:43:22   2020-07-15 11:55:45
   * A   龙岗区   宝安区   2020-07-15 11:55:55   2020-07-15 12:12:23
   * B   福田区   宝安区   2020-07-15 12:05:05   2020-07-15 12:22:33
   * A   龙岗区   龙华区   2020-07-15 11:02:08   2020-07-15 11:17:15
   * A   宝安区   龙岗区   2020-07-15 10:35:15   2020-07-15 10:40:50
   * B   龙华区   龙岗区   2020-07-15 10:45:25   2020-07-15 10:50:00
   * A   龙华区   龙岗区   2020-07-15 11:33:12   2020-07-15 11:45:35
   * B   宝安区   龙岗区   2020-07-15 12:27:20   2020-07-15 12:43:31
   * A   宝安区   龙岗区   2020-07-15 12:17:10   2020-07-15 12:33:21
   * B   福田区   龙华区   2020-07-15 10:15:21   2020-07-15 10:35:12
   * B   龙岗区   宝安区   2020-07-15 11:12:18   2020-07-15 11:27:25
   */
  //1:获取数据,转换格式
  val list: List[String] = Source.fromFile("E:\\bb.txt", "utf-8").getLines().toList
  //list.foreach(println(_))

  //2:切割和转换成时间戳
  val list1: List[(String, String, String, Long, Long)] = list.map(x => {
    val arr = x.split("   ")
    //A   龙华区   宝安区   2020-07-15 10:05:10   2020-07-15 10:25:02
    //转换时间格式
    val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val driver_id = arr.head
    val upRegin = arr(1)
    val downRegin = arr(2)
    val upTime = format.parse(arr(3)).getTime
    val downTime = format.parse(arr(4)).getTime
    (driver_id, upRegin, downRegin, upTime, downTime)
  })
  //list1.foreach(println(_))
  /**
   * (A,龙华区,宝安区,1594778710000,1594779902000)
   * (B,宝安区,福田区,1594784602000,1594785345000)
   * (A,龙岗区,宝安区,1594785355000,1594786343000)
   * (B,福田区,宝安区,1594785905000,1594786953000)
   * (A,龙岗区,龙华区,1594782128000,1594783035000)
   * (A,宝安区,龙岗区,1594780515000,1594780850000)
   * (B,龙华区,龙岗区,1594781125000,1594781400000)
   * (A,龙华区,龙岗区,1594783992000,1594784735000)
   * (B,宝安区,龙岗区,1594787240000,1594788211000)
   * (A,宝安区,龙岗区,1594786630000,1594787601000)
   * (B,福田区,龙华区,1594779321000,1594780512000)
   * (B,龙岗区,宝安区,1594782738000,1594783645000)
   */

  //3:根据司机分组
  val grouped: Map[String, List[(String, String, String, Long, Long)]] = list1.groupBy(x => x._1)
  //grouped.foreach(println(_))
  /**
   * (A,List((A,龙华区,宝安区,1594778710000,1594779902000), (A,龙岗区,宝安区,1594785355000,1594786343000),
   *        (A,龙岗区,龙华区,1594782128000,1594783035000), (A,宝安区,龙岗区,1594780515000,1594780850000),
   *        (A,龙华区,龙岗区,1594783992000,1594784735000), (A,宝安区,龙岗区,1594786630000,1594787601000)))
   *
   * (B,List((B,宝安区,福田区,1594784602000,1594785345000), (B,福田区,宝安区,1594785905000,1594786953000),
           * (B,龙华区,龙岗区,1594781125000,1594781400000), (B,宝安区,龙岗区,1594787240000,1594788211000),
           * (B,福田区,龙华区,1594779321000,1594780512000), (B,龙岗区,宝安区,1594782738000,1594783645000)))
   */

  //4:对下车时间进行排序
  val list2: List[List[(String, String, String, Long, Long)]] = grouped.toList.flatMap(x => {
    val dirver_id = x._1
    val sortBylist = x._2.sortBy(_._5)

    //5:每个司机的等客时间[先滑窗]
    val slidinglist: Iterator[List[(String, String, String, Long, Long)]] = sortBylist.sliding(2)
    slidinglist
  })
 // list2.foreach(println(_))
  println(list2)
  /**
   * List((A,龙华区,宝安区,1594778710000,1594779902000), (A,宝安区,龙岗区,1594780515000,1594780850000))
   * List((A,宝安区,龙岗区,1594780515000,1594780850000), (A,龙岗区,龙华区,1594782128000,1594783035000))
   * List((A,龙岗区,龙华区,1594782128000,1594783035000), (A,龙华区,龙岗区,1594783992000,1594784735000))
   * List((A,龙华区,龙岗区,1594783992000,1594784735000), (A,龙岗区,宝安区,1594785355000,1594786343000))
   * List((A,龙岗区,宝安区,1594785355000,1594786343000), (A,宝安区,龙岗区,1594786630000,1594787601000))
   * List((B,福田区,龙华区,1594779321000,1594780512000), (B,龙华区,龙岗区,1594781125000,1594781400000))
   * List((B,龙华区,龙岗区,1594781125000,1594781400000), (B,龙岗区,宝安区,1594782738000,1594783645000))
   * List((B,龙岗区,宝安区,1594782738000,1594783645000), (B,宝安区,福田区,1594784602000,1594785345000))
   * List((B,宝安区,福田区,1594784602000,1594785345000), (B,福田区,宝安区,1594785905000,1594786953000))
   * List((B,福田区,宝安区,1594785905000,1594786953000), (B,宝安区,龙岗区,1594787240000,1594788211000))
   */
  val list3: List[(String, Long)] = list2.map(x => {
    val second = x.last  //(A,宝安区,龙岗区,1594780515000,1594780850000)
    val first = x.head  //(A,龙华区,宝安区,1594778710000,1594779902000)
    val duration = (second._4 - first._5) / 1000
    val region = first._3
    (region, duration)
  })
 // list3.foreach(println(_))
  /**
   * (宝安区,613)
   * (龙岗区,1278)
   * (龙华区,957)
   * (龙岗区,620)
   * (宝安区,287)
   * (龙华区,613)
   * (龙岗区,1338)
   * (宝安区,957)
   * (福田区,560)
   * (宝安区,287)
   */

  //6:根据区域分组
  val map: Map[String, List[(String, Long)]] = list3.groupBy(x => x._1)
  println(map)

  /**
   * (龙华区,List((龙华区,957), (龙华区,613)))
   * (福田区,List((福田区,560)))
   * (宝安区,List((宝安区,613), (宝安区,287), (宝安区,957), (宝安区,287)))
   * (龙岗区,List((龙岗区,1278), (龙岗区,620), (龙岗区,1338)))
   */

 map.map(x => {
    val regin = x._1    //龙华区
    val Time = x._2.map(y => y._2).sum  //((957), (613))
    val num = x._2.size  //((龙华区,957), (龙华区,613))
    (regin, Time / num)
  }).foreach(println(_))


  //简化:
//  Source.fromFile("E:\\bb.txt", "utf-8").getLines().toList //读取数据和转换格式
//    .map(x => {
//      val arr = x.split("   ") //切割
//      val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") //转换日期格式
//      val driver_id = arr.head //司机
//      val upRegin = arr(1) //上车地点
//      val downRegin = arr(2) //下车地点
//      val upTime = format.parse(arr(3)).getTime //上车时间
//      val downTime = format.parse(arr(4)).getTime //下车时间
//      (driver_id, upRegin, downRegin, upTime, downTime)
//    })
//    .groupBy(x => {
//      x._1 //根据司机分组
//    })
//    .toList.flatMap(x => { //转为list格式,并且进行压平      //****破题的关键
//    x._2.sortBy(y => { //根据下车时间进行排序
//      y._4
//    }) .sliding(2) //滑窗
//      .map(y => {
//        val second = y.last //滑窗的后部分
//        val first = y.head //滑窗的前部分
//        val sumTime = (second._4 - first._5) / 1000 //求这次上车时间跟前一次下车时间的差值
//        val regin = first._3 //上车和下车交接的地点
//        (regin, sumTime)
//      })
//  }).groupBy(x=>x._1)  //根据区域分组
//    .map(x=>{
//      val regin=x._1  //地点
//      val sunTime=x._2.map(_._2).sum //分区后的总时间
//      val num=x._2.size  //分区的个数
//      (regin,sunTime/num)
//    }).foreach(println(_))



}
}
