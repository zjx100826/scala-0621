package com.atguigu.charpter08

object $12_Either {
  /**
   *
   */
  def main(args: Array[String]): Unit = {
    val tupleOrInt: Either[(Int, Exception), Int] = m1(4, 0)
    if(tupleOrInt.isRight){
      println(tupleOrInt.right.get)
    }

    tupleOrInt match {
      case Right(value)=>println("right:"+value)
      case Left((b,e))=>println(b)
    }
  }
  def m1(a:Int,b:Int)={
    try{
      Right(a/b)
    }catch {
      case e:Exception =>Left(b,e)
    }
  }
}
