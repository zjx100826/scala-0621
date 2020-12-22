package com.atguigu.charpter06

object $12_TraitMethod {

  trait Parent1 {

    def add(x: Int, y: Int) = x + y
  }

  trait Parent2 {

    def add(x: Int, y: Int) = x - y
  }

  class Sub extends Parent1 with Parent2 {
    override def add(x: Int, y: Int): Int = {
      val z = x * y
      super.add(z, x)
    }
  }

    trait Parent {
       println("Parent...........")
      def sum(x: Int, y: Int) = {
        println("Parent")
        x + y
      }
    }

    trait Sub1 extends Parent {
      println("Sub1...........")
      override def sum(x: Int, y: Int): Int = {
        println("Sub1")
        val z = x - y
        super.sum(z, x)
      }
    }

    trait Sub2 extends Parent {
      println("Sub2...........")
      override def sum(x: Int, y: Int): Int = {
        val z = x + y
        println("Sub2")
        super.sum(z, x)
      }
    }

    class AA extends Sub1 with Sub2 {
       println("AA...........")
      override def sum(x: Int, y: Int): Int = {
        val z = x * y
        println("AA")
        super.sum(z, x)
      }

    }

    /**
     * scala中可以多实现，就肯定出现一个问题： 多个父trait中都有一个同名方法,然后参数列表也一样的时候，
     * 子类实现这多个父trait之后，相当于拥有多个同名且参数列表一样的方法，此时会报错
     * 解决方法:
     * 1、子类重写父trait同名方法【重写之后再在方法体中调用父类的同名方法，实际上调用的是最后一个trait的命名方法】
     * 2、将这多个父trait的同名方法提取出来，放在一个trait中，这个父trait都来继承该trait
     * 此种方式的时候，在调用的时候是按照继承顺序从右向左开始执行
     * 初始化的顺序是按照继承顺序从左向右[如果父亲还有父亲，先要初始化父亲的父亲]开始执行,最后才初始化子类
     */

    def main(args: Array[String]): Unit = {
      val sub = new Sub
      println(sub.add(4, 5))

      val aa = new AA
      println(aa.sum(3, 4))

    }
  }