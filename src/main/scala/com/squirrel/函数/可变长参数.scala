package com.squirrel.函数

import scala.collection.mutable.ArrayBuffer

class 可变长参数 {

}
object Test{
  def capitalizeAll(args: String*) = {
    args.map { arg =>
      arg.capitalize
    }
  }


  def main(args: Array[String]): Unit = {
  var strBuffer=capitalizeAll("google","twitter")
    println(strBuffer)

  }
}
