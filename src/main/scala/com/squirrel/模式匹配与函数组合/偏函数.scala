package com.squirrel.模式匹配与函数组合

class 偏函数 {

}
object T2{
  val one: PartialFunction[Int, String] = { case 1 => "one" }


  def main(args: Array[String]): Unit = {
    one.isDefinedAt(1)
  }



}