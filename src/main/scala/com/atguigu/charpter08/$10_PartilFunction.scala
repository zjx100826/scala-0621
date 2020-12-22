package com.atguigu.charpter08

object $10_PartilFunction {
  /**
   * 偏函数: 没有match关键字的模式匹配
   *    语法:val func:PartilFunction[IN,OUT]={
   *       case 匹配条件 =>..
   *       case 匹配条件 =>..
   *       case 匹配条件 =>..
   *    }
   *    IN:是参数类型
   *    OUT:返回值类型
   */
  def main(args: Array[String]): Unit = {
    val func:PartialFunction[Any,Int]={
      case x:Int =>10
      case x:String =>20
      case x:Double =>30
      case _ =>10000
    }
    println(func(10.2))
    println(func("spark"))

    println("**"*20)
    val date2=Array[(String,(String,(String,Int)))](
      ("硅谷",("大数据0621",("张三",20))),
      ("硅谷",("大数据一班",("李四",18))),
      ("硅谷",("大数据一班",("王五",18))),
      ("硅谷",("大数据一班",("赵六",18)))
    )
    //获取名字
     date2.map(x => {
      x match {
        case (x, (y, (z, k))) => z
      }
    }).foreach(println(_))

    val getName:PartialFunction[(String,(String,(String,Int))),String]={
      case (x, (y, (z, k))) => z
    }
    date2.map(getName).foreach(println(_))


    println("***"*30)
    date2.map({
      case (x, (y, (z, k))) => z
    }).foreach(println(_))

  }
}
