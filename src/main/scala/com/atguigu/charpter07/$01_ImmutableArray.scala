package com.atguigu.charpter07

object $01_ImmutableArray {
  /**
   * scala中集合分为两类:
   * 1可变集合[集合的长度可以变,可以添加删除数据],处于scala.collection.mutable._
   * 2不可变集合[集合的长度不可以改变,不能添加删除数据],处于scala.coll.immutable._
   *
   * 不可变的数组
   * 1创建:new Array[元素的类型](数组的长度)   / Array[元素的类型](初始元素1,初始元素2,...)
   * 2获取数据: 变量名(角标)
   * 3添加数据:[不可变数组添加数据,原来数据没有改变,会生产一个新的数组]
   * + 和++的区别:
   *  +添加单个数据
   *  ++添加一个集合
   *
   *  -和--跟上面类似
   *
   *  :在前和:在后的区别
   *  :在后,数据添加到数组的前面
   *  :在前,数据添加到数组的后面
   *  不带:  默认添加到数组的后面
   *
   *  带= 与不带=的区别
   *  带= 就是在原来的数组进行改变
   *  不带=就是生成新的数组,不改变原来的数组
   *
   * 4删除数据
   * 5修改数据: 变量名(角标)=值
   * 6遍历  for(变量<-变量名)  println(变量)
   */

    def main(args: Array[String]): Unit = {
      //创建数组
      val arr1 = new Array[Int](10)
      println(arr1.toBuffer)

      val arr2 = Array[Int](1, 2, 3, 4, 5)
      println(arr2.toBuffer)

     //获取某个角标的数据
     val arr3 = arr2(2)
      println(arr3)

      //修改数据
      arr2(0) = 10
      println(arr2.toBuffer)

      //添加数据
      println("添加数据"*20)
      val arr4 = arr2.+:(6)
      println(arr4.toBuffer)

      val arr5 = arr2.:+(7)
      println(arr5.toBuffer)

      val arr6 = arr2.++(Array[Int](10, 20, 30))
      println(arr6.toBuffer)

      val arr7 = arr2.++:(Array[Int](100, 200))
      println(arr7.toBuffer)

      val arr8 = arr2.++(arr7)
      println(arr8.toBuffer)

      //没有删除数据

      //遍历
      for(i<-arr8){
        println(i)
      }

      //不可变数组转可变数组  toBuffer
      val buffer = arr2.toBuffer
      println("不可变数组转可变数组  toBuffer")
      println(buffer)
      val arr9 = buffer.-(3)
      println(arr9)

      //二维数组
      val array = Array.ofDim[Int](2, 3)
      println("二维数组"*20)
      println(array.size)
      println(array(0).size)
  }
}
