package com.atguigu.charpter07

import java.text.SimpleDateFormat

import scala.io.Source

object $$$$_xiti01 {
  def main(args: Array[String]): Unit = {
    val list1 = List[(String, String)](("a", "2020-07-11 10:51:12"), ("a", "2020-07-11 11:05:00"), ("a", "2020-07-11 11:15:20"),
      ("a", "2020-07-11 11:25:05"), ("a", "2020-07-11 11:45:00"), ("a", "2020-07-11 11:55:36"), ("a", "2020-07-11 11:59:56"),
      ("a", "2020-07-11 12:35:12"), ("a", "2020-07-11 12:58:59"), ("b", "2020-07-11 14:51:12"), ("b", "2020-07-11 14:05:00"),
      ("b", "2020-07-11 15:15:20"), ("b", "2020-07-11 15:25:05"), ("b", "2020-07-11 16:45:00"), ("b", "2020-07-11 16:55:36"),
      ("b", "2020-07-11 16:59:56"), ("b", "2020-07-11 17:35:12"), ("b", "2020-07-11 17:58:59"))

    val list2 = List[(String, String)](("a", "2020-07-11 10:51:12"), ("a", "2020-07-11 11:05:00"), ("a", "2020-07-11 11:15:20"),
      ("a", "2020-07-11 11:25:05"), ("a", "2020-07-11 11:45:00"), ("a", "2020-07-11 11:55:36"), ("a", "2020-07-11 11:59:56"),
      ("a", "2020-07-11 12:35:12"), ("a", "2020-07-11 12:58:59"), ("b", "2020-07-11 14:51:12"), ("b", "2020-07-11 14:05:00"),
      ("b", "2020-07-11 15:15:20"), ("b", "2020-07-11 15:25:05"), ("b", "2020-07-11 16:45:00"), ("b", "2020-07-11 16:55:36"),
      ("b", "2020-07-11 16:59:56"), ("b", "2020-07-11 17:35:12"), ("b", "2020-07-11 17:58:59"))

    //获取用户user_id
    val user_id1 = list1.map(x => x._1)

    val uesr_id2 = list2.map(x => x._1)
   // println(uesr_id2)

    //获取时间戳
    val sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val timechuo1 = list1.map(x => sdf.parse(x._2).getTime)


    val timechuo2 = list2.map(x => sdf.parse(x._2).getTime)


    //条件
practise1
    def practise1 = {
      val lines = Source.fromFile("E:\\info.txt").getLines().toList
      val tb = lines
        .map(str => {
          val sp = str.split(",")
          (sp(0), sp(1))
        })
      println(tb)
           val sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            def timeDiffInHourV1(date1:String, date2:String,hour: Int) = {
              val diff = sdf.parse(date2).getTime - sdf.parse(date1).getTime //算时间戳
              diff >= 0 && diff <= hour * 3600 * 1000
            }

       tb.map(tuple => {
        tb.filter(tuple1 => {
          tuple._1 == tuple1._1 && timeDiffInHourV1(tuple._2, tuple1._2, 1)
        })
      })

              .map(list => (list(0)._1,list.size))
              .groupBy(tuple => tuple._1)
              .mapValues(list => list.map(tuple => tuple._2).max)
              .foreach(println)
          }

      //    def practies3 = {
      //      val lines = Source.fromFile("E:\\info.txt").getLines().toList
      //      val tb = lines.drop(1).dropRight(1).map(str => str.split("\t").toList)
      //
      //      val sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
      //      def secondDiff(date1:String, date2:String) = {
      //        (sdf.parse(date2).getTime - sdf.parse(date1).getTime)/1000
      //      }
      //
      //      tb.sortWith((row1,row2) => row1(0) < row2(0) || (row1(0) == row2(0) && row1(3) < row2(3)) )//.foreach(x => println(x.toBuffer))
      //        .sliding(2,1)//.foreach(println)
      //        .toList
      //        .filter(list => list.head(0) == list.last(0))
      //        .map(list => (list.head(2), secondDiff(list.head(4),list.last(3))))
      //        .groupBy(tuple => tuple._1)
      //        .mapValues(list => list.map(tuple => tuple._2).sum/list.size )
      //        .foreach(println)
      //    }


      /**
       * test("2") {
       * def time_diff(down: String, up: String) = {
       * val sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
       * val dt1 = sdf.parse(down).getTime
       * val dt2 = sdf.parse(up).getTime
       * dt2 - dt1
       * }
       *
       * val src = Source.fromFile("D:\\CoderZone\\scala\\fuck-scala\\src\\main\\resources\\info2.txt")
       * val list1 = src.getLines().toBuffer
       * val list2 = list1.map(x => x.split("\t").toList) //拆分
       * val list3 = list2.sortWith((x, y) => x.head < y.head || (x.head == y.head && x.last < y.last)) //二次排序（司机id、下车时间）
       * val list4 = list3.sliding(2, 1).toList //滑窗
       * val list5 = list4.filter(x => x.head.head == x.last.head) //过滤最后一次(司机下班了~)
       * val list6 = list5.map(x => (x.head(2), time_diff(x.head.last, x.last(3)) / 1000)) //映射成(region,time_diff)
       * val list7 = list6.groupBy(x => x._1) //按region分组
       * val list8 = list7.map(x => {
       * val v = x._2.map(x => x._2)
       * (x._1, v.sum * 1.0 / v.size)
       * })
       * list8.foreach(println)
       * }
       */


      /**
       * Date date = new Date(); //获取当前时间
       *         System.out.println(date.getClass().getName());  //打印date数据类型
       *         System.out.println(date);           //打印当前时间
       * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       * String format = sdf.format(date);       //将Date类型转换成String类型
       *         System.out.println(format.getClass().getName());//打印format数据类型
       *         System.out.println(format);　　　　　　　　　　　　//打印当前时间
       */
    }


}
