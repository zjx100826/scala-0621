package com.atguigu.charpter05

object $07_Filter {
  /**
   * 3、定义一个高阶函数，根据指定的规则对数据进行过滤
   * val arr = Array(5,4,6,5)
   * 比如只需要偶数数据的结果
   * val result = Array(4,6)
   */
  def main(args: Array[String]): Unit = {
    val arr = Array(5,4,6,5)
    val func =(x:Int)=>x%2==0

    println("过滤:"+arr.filter(x => x % 2 == 0).toBuffer)

    //正常输出
    println(filter(arr, func).toBuffer)
    //值类型
    println(filter(arr, (x: Int) => x % 2 == 0).toBuffer)
    //省略类型
    println(filter(arr, (x) => x % 2 == 0).toBuffer)
    //一个参数,省略括号
    println(filter(arr, x => x % 2 == 0).toBuffer)
    //在真个代码块中只使用一次,用_ 代替
    println(filter(arr,  _ % 2 == 0).toBuffer)


  }
  //通过函数定义高阶函数
  val filter=(arr:Array[Int],func:(Int)=>Boolean)=>{
    //遍历
      //利用守卫,进行判断,符合条件则执行,for循环本没有返回值的,通过yield使其具有返回值
    for(element<-arr if(func(element))) yield
      element
  }
}
