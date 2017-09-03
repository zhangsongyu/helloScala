package com.squirrel.函数

class 新特性 {

}
object HanShu{
  def multiply(m: Int)(n: Int): Int = m * n
  val timesTwo = multiply(2)( _:Int)
  def main(args: Array[String]): Unit = {
    println(multiply(2)(3))
    println(timesTwo(2))
  }

}
