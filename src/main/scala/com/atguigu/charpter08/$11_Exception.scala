package com.atguigu.charpter08

import java.sql.{Connection, DriverManager, PreparedStatement}

import scala.util.Try

object $11_Exception {
  /**
   * java中的异常处理:
   *   1:try{..}catch( e Execption) finally{..}
   *   2:throw抛出异常  [throws Exception]
   *
   *  scala中的异常
   *   1:try{..}catch{ case e: Execption} finally{..}  [一般用于获取外部链接的时候用]
   *   2:Try().getOrElse()   [数据处理的时候用]
   */
  def main(args: Array[String]): Unit = {

    val datas = List[String](
      "1,zhangsan,20,shanghai",
      "2,lisi,28,shanghai",
      "3,wangwu,30,shanghai",
      "zhaoliu,40,shanghai",
      "4,qianqi,shanghai",
      "5,wangba,20"
    )
    //统计每个年龄的人数
//    datas.filter(x => {
//      val arr = x.split(",")
//      println(arr.toBuffer)
//      /**
//       * ArrayBuffer(1, zhangsan, 20, shanghai)
//       * ArrayBuffer(2, lisi, 28, shanghai)
//       * ArrayBuffer(3, wangwu, 30, shanghai)
//       * ArrayBuffer(zhaoliu, 40, shanghai)
//       * ArrayBuffer(4, qianqi, shanghai)
//       * ArrayBuffer(5, wangba, 20)
//       */
//      val age=arr(2)
//      age.isInstanceOf[Int]
//    })
//
    datas.map(lines=>{
      val arr=lines.split(",")
      val id=arr.head
      val name=arr(1)
      val age=Try(arr(2).toInt).getOrElse(0)
      println(Try(arr(2).toInt).isSuccess)
      //val age=try(arr(2).toInt) catch {case e:Exception =>0}
      val address=try (arr(3)) catch {case e:Exception => ""}
    })

    println(m1(4, 0))
    def m1(a:Int,b:Int)={
      try{
        a/b
      }catch {case e:Exception=>println(e.getMessage)}finally {println("finally玩玩")} //无论如何都会执行finally
    }

    //工作场景
    def jdbc()={
      //加载驱动
      Class.forName("......")
      //获取connection的链接
      val connection = DriverManager.getConnection("jdbc:mysql://hadoop102:3306/test")
      //获取statement的对象
      val statement = connection.prepareStatement("upsert into person values (?,?,?)")
      //给sql语句参数赋值
      statement.setString(1,"zjx")
      statement.setString(2,"nan")
      statement.setInt(3,24)
      //执行添加/更新
      statement.execute()
      //资源关闭
      connection.close()
      statement.close()
    }

    def jdbc1()={
      var connection:Connection = null
      var statement:PreparedStatement = null

      try{
        //加载驱动
        Class.forName("......")
        //获取connection的链接
        val connection = DriverManager.getConnection("jdbc:mysql://hadoop102:3306/test")
        //获取statement的对象
        val statement = connection.prepareStatement("upsert into person values (?,?,?)")
        //给sql语句参数赋值
        statement.setString(1,"zjx")
        statement.setString(2,"nan")
        statement.setInt(3,24)
        //执行添加/更新
        statement.execute()
      }catch {case e:Exception =>println(e.getMessage)}finally {
        //资源关闭
        connection.close()
        statement.close()
      }
    }

  }
}
