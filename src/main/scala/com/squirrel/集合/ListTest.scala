package com.squirrel.集合

/**
  * Created by Administrator on 2017/8/30.
  */

object ListTest {
  def say(word:String):Unit={
    println(word)
  }
  def main(args: Array[String]): Unit = {
    var li=List(1,2,3,4)
    var li1=List(9,8,7,6)

    var it=li.iterator
    var it1=li1.iterator
    var it0=it++(it1)
  while(it0.hasNext)
  println(  it0.next())
    ListTest say "scala"
  }
}
