package com.atguigu.charpter05

import java.text.SimpleDateFormat
import java.util.{Calendar, Date}

object $15_MethodParam {

  /**
   * java中方法在定义的时候,参数的定义方式:
   *  1:参数类型1 参数名1,参数类型2 参数名2
   *  2:可变参数:  参数类型... 参数名
   *
   *  scala中参数类型的4种方式:
   *  1:参数类型:参数名
   *  2:默认值 [age:Int=15]
   *    语法:参数名:参数类型=默认值
   *    一般把默认值参数放在最后
   *  3:带名参数 []
   *   在方法调用的时候,通过方法的参数名来进行值传递
   *  4:可变参数
   *   语法:参数名:参数类型*
   *   可变参数必须放在参数列表的最后面
   *   可变参数不可以和默认参数一起使用
   *    java中可变参数可以直接通过数组传入，scala中不可用直接传数组
   *
   */
  def main(args: Array[String]): Unit = {
    add(1,2)
    add1(1)
    //println(add2(2, 5))
    println(add2(y = 5))
    add3(5)
    println(add4("zjx",1, 2, 3, 4, 5,6))
   // add4("zjx",Array[Int](1,2,3,4,5,6,7))  scala中的可变函数不可以直接传数组

    //获取前7天的目录
    val paths=getPaths(7)
    //将数组的所有数据传递给可变函数
     readFile(paths:_*)

  }

  //1参数名:参数类型
  def add(x:Int,y:Int)={x+y}
  //2默认值
  def add1(x:Int,y:Int=10)={x+y}
  //3带名参数
  def add2(x:Int=10,y:Int)={x+y}
  def add3(x:Int,y:Int=15)={x+y}
  //4可变参数
  def add4(a:String,x:Int*):Int=x.sum
  //下面报错,说可变函数必须放在参数列表的最后面
  //def add5(x:Int*,a:String):Int=x.sum




  ///user/hive/warehose/user_info/20200914
  ///user/hive/warehose/user_info/20200913
  ///user/hive/warehose/user_info/20200912
  ///user/hive/warehose/user_info/20200911
  ///user/hive/warehose/user_info/20200910
  ///user/hive/warehose/user_info/20200909
  ///user/hive/warehose/user_info/20200908
  ///user/hive/warehose/user_info/20200907
    //需求:统计前一个星期的用户注册数
   def getPaths(n:Int)={
    //前缀
    val pathPrefix="/user/hive/warehose/user_info/"
    val arr=new Array[String](n) //n是长度
    //当前时间
    val date=new Date()
    val calendar=Calendar.getInstance()
    val format=new SimpleDateFormat("yyyyMMdd")
    calendar.setTime(date)
    for(i<-1 to n){
      calendar.setTime(date)
      calendar.add(Calendar.DAY_OF_YEAR,-i)
      val result=format.format(calendar.getTime)
      arr(i-1)=s"${pathPrefix}${result}"  //n-1是因为数组 是从0开始的
    }
    arr
  }
  def  readFile(paths:String*)={
    for(path<-paths){
      println(path)
    }
  }

}
