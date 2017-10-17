package com.squirrel.函数

class 传名调用 {

}

object Test4 {
/*  def main(args: Array[String]) {

    var result = delayed(time)
    println(result)
  }

  def time(i: Int): Long = {
    var b = 100L

    b + i
  }

  def delayed[ V](t: => V):V= {
    println(t(9))
    println("在 delayed 方法内")
    t(9)
  }
*/

}
class dy{
  def say(name:String): String = {
    s"i am $name"
  }
}


object old{

    def main(args: Array[String]) {
      delayed(time(2,3))

      delayed((new dy).say("zsy"))

      var f:String=(new dy).say("zsy")
    }

    def time(i:Int,j:Int): Long = {
      println("获取时间，单位为纳秒")
      10/i+j
    }
    def delayed[T]( f: => T ): T = {
      println("在 delayed 方法内")
      println("result： " + f)
      f
    }

}