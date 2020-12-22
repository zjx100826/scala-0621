package com.atguigu.charpter05

/**
 * 方法的简化类型:
 * 1:如果大括号里面只有一行数据,{}可以省略
 * 2:如果不需要返回值,=可以省略
 * 3:如果方法的返回值是{}中的最后一行数据,那么方法的返回值类型可以省略
 * 4:如果方法中不需要参数,可以省略小括号
 *    4.1:在定义的时候,如果省略了小括号,在调用的时候,也需要省略小括号,否则报错
 *    4.2:在定义的时候,如果没有省略小括号,在调用的时候,可以省略也可以不省略
 *  5:方法中有return关键字的时候,必须指明方法的类型
 *
 *  6:简化的时候,{}和=不能同时省略
 */
object $02_MethodSample {
  def main(args: Array[String]): Unit = {

    def add(x: Int, y: Int): Int = {
      x + y
    }

    //1:如果大括号里面只有一行语句,{}可以省略
    def add1(x: Int, y: Int): Int =
      x + y

    println(add1(1, 2))

     println("*"*100)
    //2:如果不需要返回值,=可以省略
    def add2(x: Int, y: Int) {
      x + y
    }
    println(add2(2, 5))

    //3:如果方法的返回值是{}中的最后一行数据,那么方法的返回值类型可以省略
    println("&"*100)
    def add3(x: Int, y: Int) {
      x + y
    }
    println(add3(2, 5))

    /**
     * * 4:如果方法中不需要参数,可以省略小括号
     * *    4.1:在定义的时候,如果省略了小括号,在调用的时候,也需要省略小括号,否则报错
     * *    4.2:在定义的时候,如果没有省略小括号,在调用的时候,可以省略也可以不省略
     */
    println("%"*100)
    def  add4()={
      println("**************")
    }
    //add4
    add4()

    println("^"*100)
    def add5 = println("全部都是你")
    add5


    //5:方法中有return关键字的时候,必须指明方法的类型
    println("^*"*100)
    def add6(x: Int,y :Int):Int={
     return (x + y)
    }

    println(add6(2,5))
  }

}
