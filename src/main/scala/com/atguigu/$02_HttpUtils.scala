package com.atguigu
import org.apache.commons.httpclient.HttpClient
import org.apache.commons.httpclient.methods.{GetMethod, PostMethod, StringRequestEntity}

object $02_HttpUtils {
  /**
   * client端发起get请求代码
   */
  def get(url:String) = {

    //1、创建HttpClient
    val client = new HttpClient()
    //2、创建Method[Get、Post]
    val method = new GetMethod(url)
    //3、发起请求
    val code = client.executeMethod(method)
    //4、判断状态码，是否请求成功
    if(code==200){
      //5、返回数据
      method.getResponseBodyAsString   //ResponseBody网址的存放数据  //AsString 转为String
    }else{
      null
    }
  }

  /**
   * client向服务器发起post请求
   * @param url
   * @param content
   * @return
   */
  def post(url:String,content:String) = {
    //1、创建HttpClient
    val client = new HttpClient()
    //2、创建Method
    val method = new PostMethod(url)
    //3、设置post请求的参数
    val entity = new StringRequestEntity(content,"application/json","utf-8")
    method.setRequestEntity(entity)

    //4、发起请求
    val code = client.executeMethod(method)

    //5、判断是否请求成功
    if(code==200){
      //6、返回数据
      method.getResponseBodyAsString
    }else{
      null
    }

  }

  def main(args: Array[String]): Unit = {

    //println(get("http://localhost:8080/getInfo?yy=zhangsan"))

    val content = "{\"name\":\"lisi\",\"age\":100}"
    println(post("http://localhost:8080/saveuser", content))
  }
}
