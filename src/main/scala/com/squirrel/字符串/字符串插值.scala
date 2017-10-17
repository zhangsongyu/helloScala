package com.squirrel.字符串

class 字符串插值 {

}
object T1{
  def main(args: Array[String]): Unit = {
    val name="James"
    println(s"Hello,$name")


    val height=1.9d
    println(f"$name%s is $height%2.2f meters tall")

    println(if (1>2) true else false)

  }
}