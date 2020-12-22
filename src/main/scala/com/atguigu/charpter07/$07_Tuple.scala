package com.atguigu.charpter07

object $07_Tuple {
  /**
   * 创建元祖的语法:
   * 1通过()的方式进行创建:(元素1,元素2,..)
   * 2如果创建2元元祖[二元元祖在scala中表示KV键值对] K->V
   * 一个元祖最多只能装22个元素
   * 元祖一旦定义,就不能修改了[长度和元素都不可以修改]
   * 获取元祖的元素:元素的变量名._角标[角标是从1开始]
   */
  def main(args: Array[String]): Unit = {
    class Person(val name:String,val age:Int,val address:String)


//    class School(val name:String,val clazz:Clazz)
//
//    class Clazz(val name:String,val stu:Student)
//
//    class Student(val name:String,val age:Int)


    case class School(name:String,clazz:Clazz)
    case class Clazz(name:String,stu:Student)
    case class Student(name:String,age:Int)

    val t1=("zhangsan",20,"beijing")
    val t2="lisi"->30

    //获取元素
    println(t1._1)
    println(t2._2)

    //类似于
    val person = new Person("zhangsan",20,"beijing")
    person.name
    person.age
    person.address

    val date=Array[(String,Int,String)](("lisi",20,"shenzhen"),
      ("wangwu",30,"beijing"),
      ("zhangsna",43,"beij")
    )
    //获取地址:
    for(t<-date){
      println(t._3)
    }

    val date2=Array[(String,(String,(String,Int)))](
      ("硅谷",("大数据0621",("张三",20))),
      ("硅谷",("大数据一班",("李四",18))),
      ("硅谷",("大数据一班",("王五",18))),
      ("硅谷",("大数据一班",("赵六",18)))
    )
    //获取名字
    for(t<-date2){
      println(t._2._2._1)
    }
//val data2 = Array[(String,(String,(String,Int)))](
//  ("硅谷",("大数据一班",("王二麻子",18))),
//  ("硅谷",("大数据一班",("李四",18))),
//  ("硅谷",("大数据一班",("王五",18))),
//  ("硅谷",("大数据一班",("赵六",18)))
//)
//
//    for(i<- data2) {
//
//      println(i._2._2._1)
//    }

    val date3=Array[School](
      School("guigu",Clazz("dashuju0621",Student("yiyi",20))),
      School("guigu",Clazz("dashuju0621",Student("erer",20))),
      School("guigu",Clazz("dashuju0621",Student("sansan",20))),
    )

    //获取名字
    for(t<-date3)(
     println(t.clazz.stu.name)
      )
  }
}
