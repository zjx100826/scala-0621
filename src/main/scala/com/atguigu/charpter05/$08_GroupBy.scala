package com.atguigu.charpter05

import java.util

object $08_GroupBy {
  /**
   * 定义一个高级函数，按照指定的规则对数据进行分组
   * val arr = Array("zhangsan 20 shenzhen","lisi 30 shanghai","wangwu 30 shenzhen","zhaoliu 20 shenzhen")
   * 比如按照地区进行分区结果
   * shenzhen的结果: List["zhangsan 20 shenzhen","wangwu 30 shenzhen","zhaoliu 20 shenzhen"]
   * shanghai的结果: List["lisi 30 shanghai"]
   */
 // val result = new util.HashMap[String,util.List[String]]()
 def main(args: Array[String]): Unit = {
  val arr = Array("zhangsan 20 shenzhen","lisi 30 shanghai","wangwu 30 shenzhen","zhaoliu  20 shenzhen")

   val list = arr.toList
   println(list)

   println(groupBy(arr, (x: String) => x.split(" ")(2)))


 }

  //通过定义方法创建高阶函数
  def groupBy(arr:Array[String],func:String=>String)={
    //把初始化结果装在容器中
    val result = new util.HashMap[String,util.List[String]]()
    //遍历
    for(element<-arr){
      //得到key值
      val key=func(element)
      //判断key是否存在，如果存在，代表之前已经将key - value键值对添加到map中，
           // 现在只需要将value值取出来，将目前的元素添加进去
      if(result.containsKey(key)){
        val list=result.get(key)
        list.add(element)
      }else{
        val list=new util.ArrayList[String]()
        list.add(element)
        result.put(key,list)
      }
    }
    result
  }

//   def main(args: Array[String]): Unit = {
//    val arr = Array("zhangsan 20 shenzhen","lisi 30 shanghai","wangwu 30 shenzhen","zhaoliu 20 shenzhen")
//
//
//    println(groupBy(arr, (x: String) => x.split(" ")(2)))
//    println(groupBy(arr, (x: String) => x.split(" ")(1)))
//
//  }
//
//  def groupBy(arr:Array[String],func: String => String) = {
//    //初始化最终结果的装载容器
//    val result = new util.HashMap[String,util.List[String]]()
//    //val arr = Array("zhangsan 20 shenzhen","lisi 30 shanghai","wangwu 30 shenzhen","zhaoliu 20 shenzhen")
//    //对数组进行遍历
//    for( element <- arr) {
//      val key = func(element)
//      //判断key是否存在，如果存在，代表之前已经将key - value键值对添加到map中，现在只需要将value值取出来，将目前的元素添加进去
//      if(result.containsKey(key)){
//        val list = result.get(key)
//        list.add(element)
//      }else{
//        val list = new util.ArrayList[String]()
//        list.add(element)
//        result.put(key,list)
//      }
//    }
//    result
//  }
}
