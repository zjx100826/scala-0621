package com.atguigu.charpter05

object $09_NoNameFunction {
  /**

   * 匿名函数： 没有函数名的函数称之为匿名函数
   * 匿名函数因为没有函数名不能单独调用，只能将匿名函数作为值传递给方法的参数
   */
  def main(args: Array[String]): Unit = {

    val func = (x:Int,y:Int) => x+y

    func(2,3)

    //匿名函数
    //(x:Int,y:Int) => x+y

    val arr = Array[String]("zhangsan 10 1000","lisi 20 500","wangwu 15 5000")

    println(maxBy(arr, (x: String) => x.split(" ")(1).toInt))

  }

  /**

   * 根据指定条件获取最大的数据
   * @param arr
   * @param func
   * @return
   */
  def maxBy(arr:Array[String],func: String => Int) = {
    var tmp = func(arr(0))
    var max = arr(0)
    for(index<- 1 until(arr.length)){
      val element = arr(index)
      val by = func(element)
      if(by>tmp) {
        max = element
        tmp = by
      }
    }
    max
  }
}