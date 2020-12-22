package com.atguigu.charpter07

import java.text.SimpleDateFormat

import scala.io.Source

object $$$$_xiti02 {
  /**
   *
   */
  def main(args: Array[String]): Unit = {

    driver_tab

    def driver_tab={
      val lines = Source.fromFile("E:\\driver_regin.txt").getLines().toList
      val list = lines.drop(1).dropRight(1).map(x => {
        val date=x.split("   ").toList
        (date(0),date(1),date(2),date(3),date(4))
      })
     // println(list)
      // List((A,龙华区,宝安区,2020-07-15 10:05:10,2020-07-15 10:25:02), (B,宝安区,福田区,2020-07-15 11:43:22,2020-07-15 11:55:45),
      //      (A,龙岗区,宝安区,2020-07-15 11:55:55,2020-07-15 12:12:23), (B,福田区,宝安区,2020-07-15 12:05:05,2020-07-15 12:22:33),
      //      (A,龙岗区,龙华区,2020-07-15 11:02:08,2020-07-15 11:17:15), (A,宝安区,龙岗区,2020-07-15 10:35:15,2020-07-15 10:40:50),
      //      (B,龙华区,龙岗区,2020-07-15 10:45:25,2020-07-15 10:50:00), (A,龙华区,龙岗区,2020-07-15 11:33:12,2020-07-15 11:45:35),
      //      (B,宝安区,龙岗区,2020-07-15 12:27:20,2020-07-15 12:43:31), (A,宝安区,龙岗区,2020-07-15 12:17:10,2020-07-15 12:33:21),
      //      (B,福田区,龙华区,2020-07-15 10:15:21,2020-07-15 10:35:12), (B,龙岗区,宝安区,2020-07-15 11:12:18,2020-07-15 11:27:25 ))
      val list1 = list.sortWith((x,y)=>x._4<y._4).groupBy(x=>x._1).toList //按照上车时间排序然后根据司机分组
     list1.foreach(println)

      /**
       * (A,List((A,宝安区,龙岗区,2020-07-15 10:35:15,2020-07-15 10:40:50), (A,龙岗区,龙华区,2020-07-15 11:02:08,2020-07-15 11:17:15),
       *         (A,龙华区,龙岗区,2020-07-15 11:33:12,2020-07-15 11:45:35), (A,龙岗区,宝安区,2020-07-15 11:55:55,2020-07-15 12:12:23),
       *         (A,宝安区,龙岗区,2020-07-15 12:17:10,2020-07-15 12:33:21)))
       *
       * (B,List((B,福田区,龙华区,2020-07-15 10:15:21,2020-07-15 10:35:12), (B,龙华区,龙岗区,2020-07-15 10:45:25,2020-07-15 10:50:00),
       *         (B,宝安区,福田区,2020-07-15 11:43:22,2020-07-15 11:55:45), (B,福田区,宝安区,2020-07-15 12:05:05,2020-07-15 12:22:33),
       *         (B,宝安区,龙岗区,2020-07-15 12:27:20,2020-07-15 12:43:31)))
       */
       //list1.map(tuple=>tuple._2(0))

   }

//    def time_diff(down: String, up: String) = {
//       val sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//       val dt1 = sdf.parse(down).getTime
//       val dt2 = sdf.parse(up).getTime
//       dt2 - dt1
//       }
//
//     val src = Source.fromFile("E:\\driver_regin.txt")
//     val list1 = src.getLines().toBuffer
//     val list2 = list1.map(x => x.split("\t").toList) //拆分
//   list2.foreach(println)
//    println("***************************************************************************")
//    val list3 = list2.sortWith((x, y) => x.head < y.head || (x.head == y.head && x.last < y.last)) //二次排序（司机id、下车时间）
//    list3.foreach(println)
//    println("***************************************************************************")
//
//    val list4 = list3.sliding(2, 1).toList //滑窗
//    list4.foreach(println)
//    println("***************************************************************************")
//
//    val list5 = list4.filter(x => x.head.head == x.last.head) //过滤最后一次(司机下班了~)
//    list5.foreach(println)
//    println(" list5************************************************************")
//     val list6 = list5.map(x => (x.head(2), time_diff(x.head.last, x.last(3)) / 1000)) //映射成(region,time_diff)
//    list6.foreach(println)
//     val list7 = list6.groupBy(x => x._1) //按region分组
//     val list8 = list7.map(x => {
//       val v = x._2.map(x => x._2)
//       (x._1, v.sum * 1.0 / v.size)
//       })
//   list8.foreach(println)
     }


}
