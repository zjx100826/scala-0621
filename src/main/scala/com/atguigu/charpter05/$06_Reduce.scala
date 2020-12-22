package com.atguigu.charpter05

object $06_Reduce {
  /**
   * 定义高阶函数，根据指定的逻辑对数组进行统计
   * val arr = Array(5,4,6,5)
   * 比如统计总和[还可能统计总乘积等等]
   * val sum = 20
   */
  def main(args: Array[String]): Unit = {
    val arr = Array(5,4,6,5)

    println("sum:"+arr.sum)

    val func=(agg:Int,curr:Int)=>agg+curr
    //正常输出
    println(reduce(arr ,func))
    //直接传函数的值
    println(reduce(arr, (agg: Int, curr: Int) => agg + curr))
    //省略类型
    println(reduce(arr, (agg , curr) => agg + curr))
    //方法体只用一次,用_替代
    println(reduce(arr, _ + _))
  }

  //通过方法定义高阶函数
  def reduce(arr: Array[Int],func:(Int,Int)=>Int) ={
    //从数组的第二个位置开始遍历函数
    var sum =arr(0)
    for(index<- 1 until arr.length){
      //取出下角标对应的元素
      val element=arr(index)
      //
      sum=func(sum,element)

    }
    sum
  }
}
