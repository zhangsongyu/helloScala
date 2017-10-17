package com.squirrel.集合.具体的不可变集实体类

class Test {

}
object Test{
  def main(args: Array[String]): Unit = {
    var li=1::2::3::Nil
    println(li)

    var stream=1#::2#::3#::Stream.empty
    println(stream)

  }
}
