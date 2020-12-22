package com.atguigu
import com.alibaba.fastjson.{JSON, JSONObject}

import scala.io.Source
import scala.util.Try
object $03_Home2 {

  /**
   * 需求: 统计每个省份每个城市的原始请求数
   * @param args
   */
  def main(args: Array[String]): Unit = {

    //1、读取数据
    Source.fromFile("C:\\Users\\Admin\\Desktop\\pmt.json","utf-8")
      .getLines()
      .toList
      .take(100)
      //2、解析json数据，获取ip、requetmode、processnode
      .map(line=>{

        //解析json
        val obj: JSONObject = JSON.parseObject(line)
        val ip = obj.getString("ip")
        val requestmode = obj.getInteger("requestmode")
        val processnode = obj.getInteger("processnode")

        val string: String = obj.toJSONString

        //3、根据ip获取省份、城市
        val url = s"https://restapi.amap.com/v3/ip?ip=${ip}&key=f75418e64363b8a96d3565108638c5f1"
        //https://restapi.amap.com/v3/ip?ip=114.247.50.2&output=xml&key=0d1f6fa0fbcccfcc07180a330c05411b
        val responseJson = $02_HttpUtils.get(url)
        //解析json[json字符串如果为null或者为空字符串的时候解析会报错]
        val (province,city) = Try(parseJson(responseJson)).getOrElse(("",""))

        (province,city,requestmode,processnode)
      })
      //4、按照省份、城市分组
      .filter(x=>x._1!="" && x._2!="")
      .groupBy{
        case (province,city,requestmode,processnode) =>(province,city)
      }
      //5、统计原始请求数
      .map(x=>{
        val province = x._1._1
        val city = x._1._2
        val num = x._2.filter(y=>y._3==1 && y._4>=1).size
        (province,city,num)
      })

      //6、结果展示
      .foreach(println(_))
  }

  def parseJson(json:String) = {
    val obj = JSON.parseObject(json)
    val province = obj.getString("province")
    val city = obj.getString("city")
    (province,city)
  }

}
