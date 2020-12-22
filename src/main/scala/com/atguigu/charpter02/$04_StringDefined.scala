package com.atguigu.charpter02

object $04_StringDefined {

  /**
   * java中得到String的方式:
   * 1 new Sring()
   * 2 String a ="zjx"
   * 3 字符串的拼接: "aa"+"bb"
   * 4 字符串的一些方法: "aabbcc".substring()
   *
   * scala中得到String
   * 1 双引号
   * 2 插值表达式: s"hello${变量名/表达式}
   * 3 字符串的一些方法 format
   * 4 三引号
   */

  def main(args: Array[String]): Unit = {

    //插值表达式[能够实现字符串的拼接]
    val name ="shenzhen"

    val hello ="hello" + name
    println("hello:"+hello)

    val hello2= s"hello ${name}"
    println("hello2:"+hello2)

    val hello3=s"hello ${1+1}"
    println("hello3:"+hello3 )

    //字符创的一些方法:
    println("aabbcc".substring(2))

    //%s是字符串的占位符,%f是浮点型的占位符,%d是整数的占位符
    val str ="hello %s"
    val result=str.format("lisi")
    println(result)
    //java的用法
    val aa = String.format(str,"wagnwu")
    println(aa)

    printf("hello %s","zhaoliu")

    val float ="hello %f"
    val result1=float.format(1.2)
    println(result1)

    val float1 ="hello %d"
    val result2 =float1.format(1)
    println(result2)

    val table  = "user"
    val sql =
      s"""
         |select
         | a.name,
         | a.age,
         | b.sex
         |from ${table} a
         |     left join (
         |       select c.sex
         |         from person p left join user c
         |            on p.name=c.name
         |     ) b
         | on a.id = b.id
  """.stripMargin

    println(sql)
  }

}
