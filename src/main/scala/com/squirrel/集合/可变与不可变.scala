package com.squirrel.集合

import scala.collection.mutable

class 可变与不可变 {

}

object TestMap {
  def main(args: Array[String]): Unit = {
    var colors = Map("red" -> "#FF0000",
      "azure" -> "#F0FFFF",
      "peru" -> "#CD853F")
    println("map此时不可变对象")
    println(colors.hashCode())
    colors += ("bai" -> "bbbbb")
    println(colors.hashCode())
    println(colors)


    println("map此时可变对象")
    var colors1 = collection.mutable.Map("red" -> "#FF0000",
      "azure" -> "#F0FFFF",
      "peru" -> "#CD853F")

    println(colors1.hashCode())
    colors1 += ("bai" -> "bbbbb")
    println(colors1.hashCode())
    println(colors1)

  }
}