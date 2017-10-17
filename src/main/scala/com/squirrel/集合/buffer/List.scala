package com.squirrel.集合.buffer

import scala.collection.mutable.ListBuffer

class List {

}
object TL1{
  def main(args: Array[String]): Unit = {
    var lib=ListBuffer(1,2,3,4,5)
    lib+=6
    0+=:lib

    lib.insert(2,6,6,6)
    lib-=6
    lib.remove(6)

    println(lib.toList)
  }
}