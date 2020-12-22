package com.atguigu.charpter08

import java.text.SimpleDateFormat

import scala.io.Source

object $13_Home01 {
  /**
   * 统计每个小时用户的最大登录次数
   */
  def main(args: Array[String]): Unit = {
    /**
     * a,2020-07-11 10:51:12
     * a,2020-07-11 11:05:00
     * a,2020-07-11 11:15:20
     * a,2020-07-11 11:25:05
     * a,2020-07-11 11:45:00
     * a,2020-07-11 11:55:36
     * a,2020-07-11 11:59:56
     * a,2020-07-11 12:35:12
     * a,2020-07-11 12:58:59
     * b,2020-07-11 14:51:12
     * b,2020-07-11 14:05:00
     * b,2020-07-11 15:15:20
     * b,2020-07-11 15:25:05
     * b,2020-07-11 16:45:00
     * b,2020-07-11 16:55:36
     * b,2020-07-11 16:59:56
     * b,2020-07-11 17:35:12
     * b,2020-07-11 17:58:59
     */
    //1:读取数据转换格式
    val lines: List[String] = Source.fromFile("E:\\info.txt", "utf-8").getLines().toList
    //lines.foreach(println(_))
    println(lines)

    //2:切割和转时间戳
    val list: List[(String, Long)] = lines.map(x => {
      val arr = x.split(",")
      val user_id = arr.head
      val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
      val date = format.parse(arr.last).getTime
      (user_id, date)
    })
   //list.foreach(println(_))
    /**
     * (a,1594435872000)
     * (a,1594436700000)
     * (a,1594437320000)
     * (a,1594437905000)
     * (a,1594439100000)
     * (a,1594439736000)
     * (a,1594439996000)
     * (a,1594442112000)
     * (a,1594443539000)
     * (b,1594450272000)
     * (b,1594447500000)
     * (b,1594451720000)
     * (b,1594452305000)
     * (b,1594457100000)
     * (b,1594457736000)
     * (b,1594457996000)
     * (b,1594460112000)
     * (b,1594461539000)
     */
    //3根据用户分组
    val map: Map[String, List[(String, Long)]] = list.groupBy(x => x._1)
    //map.foreach(println(_))

    /**
     * (b,List((b,1594450272000), (b,1594447500000), (b,1594451720000), (b,1594452305000), (b,1594457100000),
     *         (b,1594457736000), (b,1594457996000), (b,1594460112000), (b,1594461539000)))
     *
     *(a,List((a,1594435872000), (a,1594436700000), (a,1594437320000), (a,1594437905000), (a,1594439100000),
     *         (a,1594439736000), (a,1594439996000), (a,1594442112000), (a,1594443539000)))
     */

    //4根据需求,过滤 排查一个小时的登录次数
    map.map(x=>{
     val userid=x._1    //b
      val userlist=x._2//List((b,1594450272000), (b,1594447500000), (b,1594451720000), (b,1594452305000), (b,1594457100000),
                                                    //(b,1594457736000), (b,1594457996000), (b,1594460112000), (b,1594461539000)))
    val nums=userlist.map(y=>{
        val oneHour=userlist.filter(z=>{
          //表与表的join 过滤条件
          z._2>=y._2 && z._2<=y._2+3600000
        })
        println(oneHour)
                /**
                 * List((b,1594451720000), (b,1594452305000))
                 * List((b,1594450272000))
                 * List((b,1594452305000))
                 * List()
                 * List((b,1594457736000), (b,1594457996000), (b,1594460112000))
                 * List((b,1594457996000), (b,1594460112000))
                 * List((b,1594460112000), (b,1594461539000))
                 * List((b,1594461539000))
                 * List()
                 * List((a,1594436700000), (a,1594437320000), (a,1594437905000), (a,1594439100000))
                 * List((a,1594437320000), (a,1594437905000), (a,1594439100000), (a,1594439736000), (a,1594439996000))
                 * List((a,1594437905000), (a,1594439100000), (a,1594439736000), (a,1594439996000))
                 * List((a,1594439100000), (a,1594439736000), (a,1594439996000))
                 * List((a,1594439736000), (a,1594439996000), (a,1594442112000))
                 * List((a,1594439996000), (a,1594442112000))
                 * List((a,1594442112000), (a,1594443539000))
                 * List((a,1594443539000))
                 * List()
                  */
                  //统计次数
         val num=oneHour.size
      num
        })
//求最大的登录次数
      (userid,nums.max)
//遍历
    }).foreach(println(_))

//简化:
//    Source.fromFile("E:\\info.txt", "utf-8").getLines().toList  //读取数据和转换格式
//      .map(x=>{
//       val arr= x.split(",") //切割
//        val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//        val user_id=arr.head
//        val time=format.parse(arr.last).getTime
//        (user_id,time)
//      })
//      .groupBy(_._1) //根据用户分组
//      .map(x=>{
//        val userid=x._1  //用户iD
//        val userlist=x._2  //分组后list的集合
//        val nums=userlist.map(y=>{
//          val oneHour=userlist.filter(z=>{     // 破题关键  相当于sql的两表连接(join)
//            z._2>=y._2 && z._2-y._2<=3600000  //题目要求
//          })
//         val num=oneHour.size   //题目要求的一个小时,的个数
//         num
//       })
//       (userid,nums.max)
//      }).foreach(println(_))


//      .map(x=>{
//        val userid=x._1
//        val userlist=x._2
//        val nums=userlist.map(y=>{
//          val oneHour=userlist.filter(z=>{
//            z._2>=y._2 && z._2<=y._2+3600000
//          })
//          val num=oneHour.size
//          num
//        })
//        (userid,nums.max)
//      }).foreach(println(_))


  }
}
