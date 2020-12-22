package com.atguigu.charpter05

object $05_HighFunction {
  /**
   * 1高阶函数:就是参数类型或者返回值为函数的方法或者函数
   * 高阶函数调用的简化:
   *  1:高阶函数调用的时候可以直接传函数的值(匿名函数)
   *  2:高阶函数调用的时候可以省略其参数类型
   *  3:高阶函数调用的时候可以如果只有一个参数,()可以省略
   *  4:高阶函数调用的时候可以,传入的参数在函数体中只使用一次,则可以用_替代
   */

  def main(args: Array[String]): Unit = {


    val func = (x:Int,y:Int) => {
      println("...............")
      println("+++++++++++++++++")
      x+y
    }

    val result = addfun(2,3,func)
    println(result)

    val myfun = (x:Int,y:Int) => x*x + y*y
    println(addfun(100, 200, myfun))

    //直接传函数的值
    addfun(100,200,(x:Int,y:Int) => x*x + y*y)
    //函数传入的时候可以省略参数类型
    addfun(100,200,(x,y) => x*x + y*y)
    //addfun(100,200,(x,y) => _*_ + _*_)

    println("8"*100)
    println(addfun(100, 200, (x, y) => y - x))
    //如果函数的参数在函数体中只使用了一次，那么可以使用_代替
    //   前提:
    //      1、参数在函数体中使用的时候是按照参数的顺序使用，如果不是按照顺序使用，则不能用_代替
    //         println(addfun(100, 200, (x, y) => y - x))  x与y不能用_代替
    //      2、函数的参数只有一个，并且在函数体中没有做任何操作直接返回参数，不能用_代替
    //         hello("lisi",x=>x)  x不能用_代替，因为单个_不会进行解析，会跳出_最近的()解析成函数: x=>hello("lisi",x)
    //      3、如果函数体中有()嵌套，函数的参数在函数体的()中进行使用，而且构成了表达式，则不能用_代替
    //           printMsg("wangwu",x=>println(x*10))  函数体中有(),而且x在函数体的()中构成了表达式，此时不能用_代替
    //           printMsg("wangwu",x=>println(x))  可以用_代替，代替之后变成了 printMsg("wangwu",println(_))  此时单个_构不成表达式会跳出_最近的()解析成函数: x=>println(x)
    println(addfun(100, 200, _ - _))



    val msgFunc = (x:String) => x * 10
    hello("zhangsan",msgFunc)
    //直接传函数的值
    hello("zhangsan",(x:String) => x * 10)
    //函数的参数类型可以省略
    hello("zhangsan",(x) => x * 10)
    //如果函数参数只有一个,()可以省略
    hello("zhangsan",x => x * 10)
    //x在右边只使用了一次，可以用_代替
    hello("zhangsan",_ * 10)

    hello("lisi",(x:String)=>x)
    hello("lisi",(x)=>x)
    hello("lisi",x=>x)
    //hello("lisi",_)  // x=>hello("lisi",x)


    printMsg("wangwu",(x:String)=>println(x))
    printMsg("wangwu",(x)=>println(x))
    printMsg("wangwu",println(_))

    printMsg("wangwu",x=>println(x*10))
    //printMsg("wangwu",println(_*10))

    val add = sum(2,3)
    println(add())


  }

  def addfun(x:Int,y:Int,func:(Int,Int)=>Int) = {

    func(x,y)

  }



  val sum = (x:Int,y:Int) => {

    val name = "zhagnsan"

    val add = () => {
      x+y
    }

    add

  }

  val hello = (msg:String,func:(String) => String) =>{

    func(msg)

  }

  val printMsg = (msg:String,func:(String)=>Unit) => {
    func(msg)


  }
}
