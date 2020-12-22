package com.atguigu.charpter07

object $14_WordCountLow {
  def main(args: Array[String]): Unit = {
    val list = List("hello spark hello hadoop","hello scala hello java",
                             "hadoop flume kafka","hadoop spark flink")
    //1进行切割压平  flatmap
    val func=(x:String)=>x.split(" ")
    val list1 = list.flatMap((x: String) => x.split(" "))
    println(list1)
    //得到的结果
    //List(hello, spark, hello, hadoop, hello, scala, hello, java, hadoop, flume, kafka, hadoop, spark, flink)

    //进行分组
    val func2=(x:String)=>x
    val grouped = list1.groupBy(func2)
    println(grouped)
    //2得到的结果
    /*Map(java -> List(java), flink -> List(flink), kafka -> List(kafka), hadoop -> List(hadoop, hadoop, hadoop),
      spark -> List(spark, spark),
      scala -> List(scala), flume -> List(flume), hello -> List(hello, hello, hello, hello))*/

//    val func3=(x:(String,String))=>{
//      x._2.size
//      x._1
//    }
    //3进行统计
    val stringToInt = grouped.map(x => {
      val num = x._1
      val count = x._2.size
      (num, count)   //{}中最后一行为返回值
    })
    println(stringToInt)
    //4得到的结果  Map(java -> 1, flink -> 1, kafka -> 1, hadoop -> 3, spark -> 2, scala -> 1, flume -> 1, hello -> 4)

    //5遍历
    val unit = stringToInt.foreach(x => println(x))
    println(unit)

    /**
     * (java,1)
     * (flink,1)
     * (kafka,1)
     * (hadoop,3)
     * (spark,2)
     * (scala,1)
     * (flume,1)
     * (hello,4)
     */

    //简化方法
    list.flatMap(x=>x.split(" ")).groupBy(x=>x).map(x=>(x._1, x._2.size)).foreach(x=>println(x))
  }



}
