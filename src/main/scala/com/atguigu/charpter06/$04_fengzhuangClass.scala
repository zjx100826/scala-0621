package com.atguigu.charpter06

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.serializer.SerializeFilter

import scala.beans.BeanProperty

object $04_fengzhuangClass {
  /**
   *  @BeanProperty 只能标注非private修饰的属性，标注之后能够自动的生成java的set/get方法
   * *                只是用来兼容java的jar包
   */

    class Person(@BeanProperty var name:String, @BeanProperty var age:Int) {
    var address: String = "shanghai"

    /* def setName(name:String) = this.name = name
        def getName() = this.name
        def getAge() = this.age
        def setAge(age:Int) = this.age = age*/
  }

  /**
   *scala中提供了默认的get/set方法。

   *    默认get的方法名就是属性名
   *    默认的set的方法名就是： 属性名_=
   */

  def main(args: Array[String]): Unit = {
   val person= new Person("lisi",20)
//    println(person.age)
//    println(person.name)

    println(person.getAge())
    println(person.getName)


    /**
     * JSON的格式:
     * 1:普通的对象,Map:由{}表示,属性名用""包裹,属性值如果是字符串类型也用""包裹,属性名和属性值之间用:隔开
     *    属性和属性之间用,隔开
     *class Person{var name:String=_
     *             var age:Int=_
     *       }
     *   val person = new Person
     *      person.name="lisi"
     *      perosn.age =20
     *
     * 2:数组,list,set由[]表示,[]中的每个元素由,分割
     *
    val arr=Array[String]("hello","word","scala")
    arr的JSON格式:["hello","word","scala"]
    val persons = Array[Person]( new Person("lisi",20),new Person("wangwu",30))
    persons的JSON格式:[{"name":"lisi","age":20},{"name":"wangwu","age":30}]
     *
     */

    /**
     * 解析JSON:
     * 1将对象转成JSON格式
     * JSON.toJSONString(person,null.asInstanceOf[SerializeFilter])
     * 2将json转成对象【json字符串的属性必须要与对象的属性名一致，如果不一致，则json的属性值不能赋值给对象的属性】
     * JSON.parseObject(json,classOf[person])
     */

    //1将对象转成JSON格式
      //* JSON.toJSONString(person,null.asInstanceOf[SerializeFilter])
    val jsonstr = JSON.toJSONString(person, null.asInstanceOf[SerializeFilter])
    println(jsonstr)

    //* 2将json转成对象【json字符串的属性必须要与对象的属性名一致，如果不一致，则json的属性值不能赋值给对象的属性】
    //* JSON.parseObject(json,classOf[person])
    val json = "{\"name\":\"阿里巴巴\",\"age\":100}"
    val person1 = JSON.parseObject(json, classOf[Person])
    println(person1.age)
    println(person1.name)
  }
}
