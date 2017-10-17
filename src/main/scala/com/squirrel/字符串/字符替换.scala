package com.squirrel.字符串

import scala.io.Source

class 字符替换 {

}

object strReplace extends App {
  var source = Source.fromFile("/Users/zhangsongyu/IdeaProjects/helloScala/src/main/scala/com/squirrel/字符串/replace.txt")
  var map = Map[String, String]("name" -> "zhangsan",
    "age" -> "5",
    "sex" -> "man",
    "mine" -> "lisi")
  var result = new StringBuilder


  try {

    source.getLines().foreach(x => {
      var temp = x

      getbds(x).foreach(p => {
        temp = temp.replace(p, map.getOrElse(p.substring(1, p.length - 1).replaceAll("[\\s*]", ""), p))
      })
      result ++= temp + "\n"
    })

    println(result.toString())
  } finally {
    source.close()
  }

  def getbds(s: String) = {
    var rule = "[{](\\s)?\\S*(\\s)?[}]".r
    rule.findAllIn(s)
  }
}