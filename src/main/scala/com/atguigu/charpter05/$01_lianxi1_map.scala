package com.atguigu.charpter05



object $01_lianxi1_map {
  /**
   * 1、定义一个高阶函数，根据指定的逻辑对数组中的每个元素进行操作
   * val arr =Array("hello","word","python","scala")
   * 比如将数组的每个元素转成字符串长度[还可能进行其他操作]
   * val result = Array(5,4,6,5)
   */
  def main(args: Array[String]): Unit = {

    val arr =Array("hello","word","python","scala")

    println("**"+arr.map(x => x.length).toBuffer)

    val func=(x:String)=>x.length
    //正常步骤
    println(map(arr, func).toBuffer)
    //匿名步骤
    println(map(arr, (x: String) => x.length).toBuffer)
    //类型省略
    println(map(arr, (x) => x.length).toBuffer)
    //只有一个参数,()可以省略
    println(map(arr, x => x.length).toBuffer)
    //函数的参数只使用一次,可以用_代替
    println(map(arr, _.length).toBuffer)
  }

  //通过函数定义高阶函数
  val map=(arr:Array[String],func:(String)=>Int)=>{
    //对数据进行遍历
    for(element<-arr) yield {
      //对数组的每个元素进行处理
      func(element)
    }
  }
}
