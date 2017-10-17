package com.squirrel.模式匹配与函数组合

class 函数组合 {


}
object T1{
  def f(s: String) = "f(" + s + ")"
  def g(s: String) = "g(" + s + ")"

  //compose 组合其他函数形成一个新的函数 f(g(x))
  val fComposeG = f _ compose g _

  //调用顺序是先调用第一个函数，然后调用第二个，即g(f(x))
  val fAndThenG = f _ andThen g _

  def main(args: Array[String]): Unit = {

    println(fComposeG("str"))
    println(fAndThenG("str"))
  }
}
