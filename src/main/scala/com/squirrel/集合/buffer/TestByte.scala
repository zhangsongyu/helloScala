package com.squirrel.集合.buffer

import scala.collection.mutable.ListBuffer

class TestByte {

}
object TestByte extends App{
  val lb=ListBuffer[Array[Byte]]()
  lb += "haha".getBytes()
  lb+="hehe".getBytes()
  val lbs=lb.toList
  var res=lbs.flatten.toArray


  println(new String(res))
}