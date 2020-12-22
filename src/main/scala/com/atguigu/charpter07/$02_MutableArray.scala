package com.atguigu.charpter07

import scala.collection.mutable.ArrayBuffer

object $02_MutableArray {
  /**
   * 可变数组:
   * 1创建: new ArrayBuffer[类型](数组的长度)  /  ArrayBuffer[类型](初始化元素1,..)
   * 2添加
   * 3查询
   * 4修改
   * 5删除[如果有多个相同的数据,删除时候,只会删除从左到右的第一个]
   * 6遍历
   */
  def main(args: Array[String]): Unit = {
    //创建数组
    val arr = new ArrayBuffer[Int](10)
    println(arr)
    val arr1 = ArrayBuffer[Int](1, 2, 3, 4, 5)
    println(arr1)

    //添加数据
    println("添加数据"*20)
    val arr2 = arr1.+:(0)
    println(arr2)

    val arr3 = arr2.:+(6)
    println(arr3)

    arr1.+=(10,20)
    println(arr1)

    arr1.++=(arr2)
    println(arr1)

    val arr5 = arr1.++:(Array[Int](20, 30))
    println(arr5)

    val arr6 = arr1.++(Array[Int](50,60))
    println(arr6)

    //删除数据[如果有多个相同的数据,删除时候,只会删除从左到右的第一个]
    println("删除数据"*10)
    val arr8 = arr1.-(5)
    println(arr8)

    arr1.-=(10,20)
    println(arr1)

    val arr9 = arr1.--(arr2)
    println(arr9)

    val arr10 = arr9.-=(arr9(0))
    println(arr10)

    //查询某个角标的数据
    println("查询某个角标的数据"*10)
    println(arr1(0))
    println(arr1(1))
    println(arr1(2))

    //修改数据
    println(arr9(2))

    //可变数组转不可变数组
    val array = arr9.toArray
    println(arr9)
    println(array.toBuffer)

  }
}
