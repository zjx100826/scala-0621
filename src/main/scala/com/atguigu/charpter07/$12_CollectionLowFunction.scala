package com.atguigu.charpter07

/**
 * sortBy:根据字段来排序,默认是升序
 * sortWith:根据自己制定的规则来进行排序
 * sorted:默认是升序排序,一维的集合
 */
object $12_CollectionLowFunction {
  def main(args: Array[String]): Unit = {
    val list=List(1,3,5,8,4,9)
    //求和
    val sum = list.sum
    println("求和:"+sum)

    //求最大值
    println(list.max)

    //求最小值
    println(list.min)

    //排序[默认按照升序排序]
    val sorted = list.sorted
    println(sorted)

    //降序排序
    println(list.sorted.reverse)

    //sortBy
    val func=(x:Int)=>{x}
    println(list.sortBy(func))
    //将函数值直接传进去
    println(list.sortBy((x: Int) => {
      x
    }))

    //去掉函数的类型
    println(list.sortBy((x) => x))
    //如果参数只有一个,可以去掉()
    println(list.sortBy(x => x))
    //如果只使用一次,可以用_替代
    //println(list.sortBy(_))


    //****sortBy
    val list2 = List[(String,Int)]( ("zhangsan",15),("lisi",18),("wangwu",20),("zhaoliu",12) )
    //按照学生的年纪排序[升序]
    val func1=(x:(String,Int))=>x._2
    val list1 = list2.sortBy(func1)
    println(list1)

    //******sortWith
    //升序
    // val list=List(1,3,5,8,4,9)
    val list3 = list.sortWith((x, y) => x < y)
    println(list3)
    //降序
    val list4 = list.sortWith((x, y) => x > y)
    println(list4)
  }
}
