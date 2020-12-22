package com.atguigu.charpter06

object $10_TraitDefind {
  /**
   * scala中也是单继承,多实现[trait]
   *
   * 特质
   *  语法:trait 特质名
   *   scala的特质中既可以定义抽象方法，也可以定义具体方法
   *   既可以定义抽象属性也可以定义具体属性
   *
   *   子类继承特质:
   *   1:如果不需要继承父类,实现第一个特质用extends,在实现其他特质就用with
   *   2:如果需要继承父类,此时继承父类用extends,特质用with
   */
  trait Log{
    //抽象方法
    def add(x:Int,y:Int):Int
    //具体方法
    def add1(x:Int,y:Int):Int={x+y}
    //抽象属性
    val name:String
    //具体属性
    val age:Int=15
  }

  trait Log2{}

  class Error extends Log with Log2{
    override def add(x: Int, y: Int): Int = x*y

    override val name: String = "xijinping"
  }

  def main(args: Array[String]): Unit = {
    val error = new Error
    println(error.name)
    println(error.age)
    println(error.add(1, 5))
    println(error.add1(1, 5))
  }
}
