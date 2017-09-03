package com.squirrel.对象

/**
  * Created by Administrator on 2017/8/30.
  */
class 单例对象 {

}
class Point2(val xc: Int, val yc: Int) {
  var x: Int = xc
  var y: Int = yc
  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy
  }
}

object Test2 {
  def main(args: Array[String]) {
    val point = new Point2(10, 20)
    printPoint

    def printPoint{
      println ("x 的坐标点 : " + point.x);
      println ("y 的坐标点 : " + point.y);
    }
  }
}