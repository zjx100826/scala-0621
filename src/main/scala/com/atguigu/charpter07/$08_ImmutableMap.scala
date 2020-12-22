package com.atguigu.charpter07

object $08_ImmutableMap {
  /**
   * Map的创建方式:
   *  1Map[K的类型,V的类型]((K1,V1),(K2,V2),...)
   *  2Map[K的类型,V的类型](K1->V1,K2->V2,..)
   *
   *  Option:提醒外部值可能为空,提供外部进行处理
   *  Some:代表非空,数据封装在Some中
   *  None:代表空值
   */
  def main(args: Array[String]): Unit = {
    //创建
    val map = Map[String, Int](("zhangsan", 15), ("lisi", 20))
    val map1 = Map[String, Int]("xijingpin" -> 65, "mayun" -> 60)
    println(map)
    println(map1)

    //添加数据
    val map2 = map.++(Map[String, Int](("wangwu", 22), ("zhaoliu", 25)))
    println(map2)

    val map3 = map1.++(Map[String, Int]("wangbaoqiang" -> 50))
    println(map3)

    //删除数据
    println("删除数据//"*20)
    val map4 = map.-("lisi")
    println(map4)

    val map5 = map1.--(Array[String]("xijingpin", "mayun"))
    println(map5)

    //获取元素[根据K值获取V值]
    println("获取元素//"*10)
    val map6 = map("lisi")
    println(map6)
    println(map.get("lisi"))
    val map7 = map.getOrElse("zhangsan1", 100) //getOrElse根据K值去获取,如果K值没有,用默认值进行替代
    println("map7="+map7)

    //修改元素
    println("  //修改元素"*20)
    val map8 = map.updated("lisi", 500)
    println(map8)

    //遍历
    for(key<-map){
      println(key)
    }

    //获取所有的key'
    for(key1<-map.keys){
      println("获取所有的key:"+key1)
    }

    //获取所有的value
    for(key2<-map.values){
      println("获取所有的value:"+key2)
    }
  }
}
