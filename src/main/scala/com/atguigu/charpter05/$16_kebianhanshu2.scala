package com.atguigu.charpter05

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.{Calendar, Date}

import com.atguigu.charpter05.$15_MethodParam.{getPaths, readFile}

object $16_kebianhanshu2 {

  ///user/hive/warehose/user_info/20200914
  ///user/hive/warehose/user_info/20200913
  ///user/hive/warehose/user_info/20200912
  ///user/hive/warehose/user_info/20200911
  ///user/hive/warehose/user_info/20200910
  ///user/hive/warehose/user_info/20200909
  ///user/hive/warehose/user_info/20200908
  ///user/hive/warehose/user_info/20200907
  //需求:统计前一个星期的用户注册数

  def main(args: Array[String]): Unit = {
    //获取前7天的目录
    val paths=getPaths(7)
    //将数组的所有数据传递给可变函数
    readFile(paths:_*)
  }

//  def getPath(n:Int)={
//    //获取当前时间
//    val localDateTime = LocalDateTime.now()
//    //格式化操作
//    val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
//    //对当前时间进行操作
//    val str = localDateTime.plusDays(-1).format(formatter)
//    println(str)
  //}

  def getPath(n:Int)={
    //创建数组
    val array = new Array[String](n)
    //前缀
    val pathPrefix="/user/hive/warehose/user_info/"
    //获取当前时间
    val date = new Date()
    val calendar = Calendar.getInstance()
    //格式化
    val format = new SimpleDateFormat("yyyyMMdd")

    for(i<-1 to n){
      //设置当前时间
      calendar.setTime(date)
      //对时间进行操作
      calendar.add(Calendar.DAY_OF_YEAR,-1)
      //获取当前时间
      val str = format.format(calendar.getTime)
      array(i-1)=s"${pathPrefix}${str}"
    }
    array

  }
  def readFile(paths:String*)={
    for(path<-paths){
      println(path)
    }
  }
}
