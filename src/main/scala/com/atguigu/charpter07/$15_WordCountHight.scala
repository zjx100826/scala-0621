package com.atguigu.charpter07

object $15_WordCountHight {
  def main(args: Array[String]): Unit = {
    val list = List(("Hello Scala Spark World", 4), ("Hello Scala Spark", 3), ("Hello Scala", 2), ("Hello", 1))
  //  1切割,压平
    val func=(x:(String,Int))=>{
     x._1.split(" ").map(y=>(y,x._2))
    }


    val list1 = list.flatMap(x => {
      val line = x._1.split(" ")  //Hello Scala Spark World Hello Scala Spark Hello Scala Hello
      line.map(y => (y,x._2))
    })
    println(list1)

    val value = list.flatMap(x=>{ x._1.split(" ").map(y=>(y,x._2))})
 //得到的结果:List((Hello,4), (Scala,4), (Spark,4), (World,4), (Hello,3), (Scala,3), \
    //                (Spark,3), (Hello,2), (Scala,2), (Hello,1))

//2分组
    val func2=(x:(String,Int))=>x._1
    val list2 = list1.groupBy(func2)
    println(list2)
    //得到的结果
    //Map(Hello -> List((Hello,4), (Hello,3), (Hello,2), (Hello,1)), Spark -> List((Spark,4), (Spark,3)),
    // Scala -> List((Scala,4), (Scala,3), (Scala,2)), World -> List((World,4)))

    //3统计
    val unit = list2.map(x => {
      val word = x._1
      //val num = x._2.map(x => x._2).sum



      val tuple = x._2.reduce((agg, curr) => {
        //agg (Hello,4) curr(Hello,3)
        (agg._1, agg._2 + curr._2)
      })
      val num = tuple._2
      (word, num)
    }).foreach(x => println(x))
    println(unit)

    //简化:
    list.flatMap(x=>{x._1.split(" ").map(y=>(y,x._2))}).groupBy(x=>x._1).map(x=>{
      (x._1,x._2.reduce((agg,curr)=>(agg._1,agg._2+curr._2))._2)
    }).foreach(println(_))



  }
}
