package com.squirrel.函数

class 高街函数 {

}
object Test5 {
  def main(args: Array[String]) {

    println( apply( layout, 10) )

  }
  // 函数 f 和 值 v 作为参数，而函数 f 又调用了参数 v
  def apply(f: Int => String, v: Int) = f(v)

  def layout[A](x: A) = "[" + x.toString() + "]"

}