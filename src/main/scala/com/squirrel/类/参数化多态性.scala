package com.squirrel.类

class 参数化多态性 {

}
object T2{
  def drop1[A](l: List[A]) = l.tail


  def id[T](x:T) = x
  def main(args: Array[String]): Unit = {
   println( drop1[String](List("1","2")))

    println(id[Int](1))
  }
}