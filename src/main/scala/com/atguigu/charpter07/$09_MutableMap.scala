package com.atguigu.charpter07
import scala.collection.mutable

/**
 *Map总结:
 * 修改数据:update(key值,默认值) 如果key不存在,则会把这个kv添加进去 ,如果key存在,则修改v值
 * 删除数据:多余一个remove(k值)
 * 获取元素:普通方式  加 getOrElse(k值,默认值)  若k存在,则获取k对应的v值,如果k不存在,则获取默认值
 */
object $09_MutableMap {
  def main(args: Array[String]): Unit = {
    //创建
    val map = scala.collection.mutable.Map[String, Int](("lisi", 20), ("wangwu", 25))
    val map1= scala.collection.mutable.Map[String, Int]("xige" -> 65, "pingge" -> 60)

    //添加数据
    map.put("haha", 88)
    println(map)

    val map2 = map.+(("zhaoliu", 30))
    println(map2)

    val map3 = map.+=(("laoqi", 35))
    println(map3)

    val map4 = map.++=(map2)
    println(map4)


    val map5 = map.++(Map[String,Int]("aa"->10,"bb"->20))
    println(map5)

    val map6 = map.++=(Map("cc" -> 33, "dd" -> 44))
    println(map6)

    val maybeInt = map1.put("zjx", 24)   /////**********
    println(map1)

    //删除数据
    println(" //删除数据"*20)
    val map7 = map1.-("zjx")

    val map8 = map1.-=("xige")
    println(map8)

    val map9 = map1.--(List("zjx", "pingge"))
    println(map9)

    map1.remove("zjx")
    println(map1)

    val map10 = map1.--=(List("zjx", "pingge"))
    println(map10)


    //获取key的value值
    println("获取key的value值")
    println(map)
    println(map("cc"))
    println(map.getOrElse("laoqi", 1000))
    //获取所有的key
    val keys = map.keys
    println(keys)
    for(key<-keys){
      println(key)
    }

    //修改key的value值
    map("laoqi")=100
    println(map)

    map.update("laoqi",500)
    println(map)

    //获取所有的values
    println("//获取所有的values"*5)
    val values = map.values
    println(values)
  }
}
