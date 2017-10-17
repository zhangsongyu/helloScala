package com.squirrel.集合.具体的不可变集实体类

class TestStream {

}

object TestStream {

  def fibFrom(a: Int, b: Int): Stream[Int] = a #:: fibFrom(b, a + b)

  def main(args: Array[String]): Unit = {
    var stream = 1 #:: 2 #:: 3 #:: Stream.empty
    println("stream被特别定义为懒惰计算"+stream)
    println(stream.toList)


    val fibs = fibFrom(1, 2).take(7)
println(fibs.toList)

    def fibList(a:Int,b:Int):List[Int]=a::fibList(b,a+b)

    var fibl=fibList(1,2)
    println(fibl)
  }
}