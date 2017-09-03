package com.squirrel.特征

/**
  * Created by Administrator on 2017/8/31.
  */
trait Equal {
  var s = "jiekou"

  def isEqual(x: Any): Boolean

  def isNotEqual(x: Any): Boolean = !isEqual(x)
}

class Point(xc: Int, yc: Int) extends Equal {

  s = "zilei"
  var x: Int = xc
  var y: Int = yc

  override def isEqual(obj: Any):Boolean = {
    obj.isInstanceOf[Point] &&
      obj.asInstanceOf[Point].x == x
  }
}

object Test {
  def main(args: Array[String]) {
    val p1 = new Point(2, 3)
    val p2 = new Point(2, 4)
    val p3 = new Point(3, 3)
    println(p1.s)
    println(p1.isNotEqual(p2))
    println(p1.isNotEqual(p3))
    println(p1.isNotEqual(2))
    var s:String="1"
    var d="1"
    s.isInstanceOf[String]

  }
}
