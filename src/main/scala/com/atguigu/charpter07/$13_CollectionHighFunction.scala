package com.atguigu.charpter07

object $13_CollectionHighFunction {
  def main(args: Array[String]): Unit = {

    val list = List[String]("spark", "hello", "hadoop", "scala", "flume", "kafka")
    //map(f:集合元素的类型 =>B)***************
    //map里面的函数正对是集合的每个元素,B是正对元素进行操作后的结果类型
    //场景:一对一[通过map计算之后会生产新的集合,长度跟原来的保持一致]
       //求每个元素的长度&&&&&&&&&&&&&&&&&&&
    val func1=(x:String)=>x.length
    println(list.map(func1))
    //直接传值类型
    println(list.map((x: String) => x.length))
    //去掉类型
    println(list.map((x) => x.length))
    //只有一个参数,去掉()
    println(list.map(x => x.length))
    //只调用一次,用_替代
    println(list.map(_.length))

    println("filter//"*10)//****************************
    //filter用于筛选数据,正对是集合的每个元素
    //filter(p:集合的元素类型=>Boolean)
    //filter保留的是函数值返回为true的数据
    val list2=List(1,2,3,4,5,6)
      //需求:求其中的偶数&&&&&&&&&&&&&&&
    val func2=(x:Int)=>x%2==0
    val list1 = list2.filter(func2)
    println(list1)

    println("foreach//"*5)//**********************
    //foreach正对的也是集合中的每个元素
    //foreach(f:集合的元素类型=>U)
    //需求: 遍历
    val func3=(x:String)=>println(x)
    val list4 = list.foreach(func3)
    println(list4)

    println("flatten//"*10)
    //flatten 用来压平
    //场景:一对多  [集合通过flatten亚平之后会产生一个新的集合,新的集合的长度大于等于原来集合的长度]
    val list3 = List[List[String]](
      List("hello", "spark"),
      List("hadoop", "flume"),
      List("scala", "kafka")
    )
    val list5 = list3.flatten
    println("压平")
    println(list5)

    println("flatMap//"*10)
    //flatMap= flatten+map
    //场景:一对多
     //需求:将其拆开,压平
    val list6=List[String]("hello spark","python scala","hadoop flume kafka")
    val list7 = list6.map(x => x.split(" "))
    val flatten = list7.flatten
    println(flatten)
    println("*"*100)
    val list8 = list6.flatMap(x => x.split(" "))
    println(list8)

    //group by根据指定的K进行分组
    //group by (f:元素的类型=>分组K的类型)
    //场景:多对一
    println("group by//"*10)
    val list9=List[(String,String)](("宝安区","尚硅谷"),("宝安区","黑马"),("福田区","中国平安"),("南山区","腾讯"))
    val func4=(x:(String,String))=>x._1
    val map = list9.groupBy(func4)
    println(map)
    map.foreach(println)
    println("**&&&&&&&&&&&&&&&^***************")
    val stringToTuple = map.map(tump => {
      ( tump._2(0))
    })
    stringToTuple.foreach(println)

    println("reduce//"*10)//****************************
    //reduce用于聚合,reduce的最终结果是单个值
    //reduce(f:(上一次的聚合结果的类型,当前要聚合的元素的类型)=>计算结果的类型)
      //求和:******************
    val list10 = List[Int](1,3,5,2,4,6,10,9)
    println(list10.reduce((agg, curr) => {
      println(agg, curr)
      agg + curr
    }))
    /**
     * val list2=10 = List[Int](1,3,5,2,4,6,10,9)
     * 计算过程：
     *   agg: 上一次的聚合结果【第一次计算的时候agg的值=集合第一个元素】  curr: 当前要聚合的元素
     *   第一次计算：
     *      agg= 1   curr = 3    (agg, curr) => agg + curr)  结果: 4
     *   第二次计算:
     *     agg=4  curr= 5   (agg, curr) => agg + curr)  结果: 9
     *   ...
     */
    println("+"*100)
    //reduceRight(f:(当前需要聚合的类型,上一次聚合结果的类型)=>{})
    println(list10.reduceRight((agg, curr) => {
      println(agg, curr)
      agg + curr
    }))

    println("fold//"*10)
    //fold
    println(list10.fold(10)((agg, curr) => {
      println(agg, curr)
      agg + curr
    }))

    println("foldRight//"*5)
    println(list10.foldRight(10)((agg, curr) => {
      println(agg, curr)
      agg + curr
    }))



  }
}
