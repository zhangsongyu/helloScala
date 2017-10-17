package com.squirrel.集合

import com.cache.Cache

import scala.collection.JavaConverters._
import scala.collection.mutable

/**
  * Created by Administrator on 2017/9/1.
  */
class MapTest {

}
object MapTest{
  def main(args: Array[String]): Unit = {
    val colors = Map("red" -> "#FF0000",
      "azure" -> "#F0FFFF",
      "peru" -> "#CD853F")

    val nums: Map[Int, Int] = Map()

    println( "colors 中的键为 : " + colors.keys )
    println( "colors 中的值为 : " + colors.values )
    println( "检测 colors 是否为空 : " + colors.isEmpty )
    println( "检测 nums 是否为空 : " + nums.isEmpty )
  }
}


object Test1 {
  def main(args: Array[String]) {
    val colors1 = Map("red" -> "#FF0000",
      "azure" -> "#F0FFFF",
      "peru" -> "#CD853F")
    val colors2 = Map("blue" -> "#0033FF",
      "yellow" -> "#FFFF00",
      "red" -> "#FF0000")

    //  ++ 作为运算符
    var colors = colors1 ++ colors2
    println( "colors1 ++ colors2 : " + colors )
    println(colors get "red" get)
    println(colors("red"))

    //  ++ 作为方法
    colors = colors1.++(colors2)
    println(colors+("bai"->"000"))
    println( "colors1.++(colors2)) : " + colors )

    var map=mutable.Map("a"->1,"b"->2)
    map+=("b"->3)
    println(map)

  }
}

object TestMap1 extends App{
  var mm=mutable.HashMap("a"->1)
  mm.update("a",2)

    mm.get("sdfs")
  println(mm)




   var m1:mutable.HashMap[String,Any]= mutable.HashMap.empty



m1.put("d", List(1,2,3))
}