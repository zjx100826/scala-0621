package com.atguigu.charpter07

import scala.collection.immutable.Queue
import scala.collection.mutable

object $16_Queue {
  /**
   * 对列分为:可变对列和不可变对列
   *
   * 总结:不可变对列时候,调用dequeue出队
   */


  //不可变对列

  //创建不可变对列
  def main(args: Array[String]): Unit = {


    val queue: Queue[Int] = Queue[Int](1, 2, 3, 4, 5, 6)
    println(queue)

    //添加对列
    val queue1: Queue[Int] = queue.:+(0)
    println(queue1)
    val queue2: Queue[Int] = queue.+:(7)
    println(queue2)
    val queue3: Any = queue.++:(Array[Int](10, 20, 30))
    val queue4: Queue[Int] = queue.++(Array(100, 200))
    println(queue4)

    //删除数据
    println("****" * 20)
    val queue5: Queue[Any] = queue.enqueue(1000)  //入队到队伍的最后面
    println(queue5)

    println("不可变的对列的出队")
    val dequeue = queue.dequeue  //出队: 出左边的第一个 形成一个元祖
    println(dequeue)
    println(queue)

    //可变对列***************
      //创建可变对列
      val queue6 = mutable.Queue[Int](2, 4, 6, 8, 10)
    //添加数据
    val queue7 = queue6.:+(12)
    val queue8 = queue6.+:(0)
    val queue9 = queue6.++(Array(16, 14))
    val queue10 = queue6.++:(Array(20, 30))

    val queue11 = queue6.++=(Array(100, 200))
    println(queue11)

    //删除数据
    val unit = queue6.enqueue(1000)   //添加到最后
    println(queue6)
    println(unit)

    val i = queue6.dequeue()   //将原来对列的左边开始的第一个元素出队
    println(queue6)
    println(i)
  }
}