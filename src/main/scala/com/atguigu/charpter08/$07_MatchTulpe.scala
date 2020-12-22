package com.atguigu.charpter08

object $07_MatchTulpe {
  /**
   * 匹配元祖
   */
  def main(args: Array[String]): Unit = {
    val t1=("zjx",24,"shenzhen")
    t1 match {
        //匹配元素时候,匹配元祖的长度必须和定义元祖的长度一样,否则报错
      //case (x:String,y:Int,z:String) =>println(s"${x}  ${y}  ${z}")
      case (x,y,z) =>println(s"${x}  ${y}  ${z}")
     // case (x,y,z,k) =>println()
    }

    val date2=Array[(String,(String,(String,Int)))](
      ("硅谷",("大数据0621",("张三",20))),
      ("硅谷",("大数据一班",("李四",18))),
      ("硅谷",("大数据一班",("王五",18))),
      ("硅谷",("大数据一班",("赵六",18)))
    )

    //获取名字
    date2.map(x=>x._2._2._1).foreach(println)

    //匹配名字
    println("*"*100)
    date2.map(x=>{
      x match {
       // case (region,(clazz,(name,age))) =>name
        case (x:String,(y:String,(z:String,k:Int))) =>println(s" ${z} ")
      }
    })


  }


}
