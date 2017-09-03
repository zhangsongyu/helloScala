package com.squirrel.正则

import scala.util.matching.Regex

/**
  * Created by Administrator on 2017/9/1.
  */
object Test {
  def main(args: Array[String]) {
    val pattern = new Regex("(S|s)cala")  // 首字母可以是大写 S 或小写 s
    val str = "Scala is scalable and cool"

    println((pattern findAllIn str).mkString(","))   // 使用逗号 , 连接返回结果

    println((pattern.findAllIn( str)).mkString(","))   // 使用逗号 , 连接返回结果

  }
}

object Test1 {
  def main(args: Array[String]) {
    val pattern = "Scala".r
    val str = "Scala is Scalable and cool"

    println(pattern findFirstIn str)
  }
}

object Test2 {
  def main(args: Array[String]) {
    val pattern = "(S|s)cala".r
    val str = "Scala is scalable and cool"

    println(pattern replaceAllIn (str, "Java"))
  }
}