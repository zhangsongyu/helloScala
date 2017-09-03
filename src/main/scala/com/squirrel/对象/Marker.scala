package com.squirrel.对象

// 私有构造方法
class Marker (val color:String) {

  println("创建" + this)

  override def toString(): String = "颜色标记："+ color

}



// 伴生对象，与类共享名字，可以访问类的私有属性和方法
object Marker{
  private val markers: Map[String, Marker] = Map(
    "red" -> new Marker("red"),
    "blue" -> new Marker("blue"),
    "green" -> new Marker("green")
  )

  def apply(color:String):Any = {
    if(markers.contains(color))
      markers(color)
    else null
  }

  def apply(small:String,color:String) = {
    println(small)
  }

  def describe(small:String,color:String) = {
    println(small+" "+color)
  }
  def getMarker(color:String) = {
    if(markers.contains(color)) markers(color) else null
  }
  def main(args: Array[String]) {
    val mi=new Marker("无色")
    Marker("tian","baise")
    Marker.describe("ku","hei")

    println(Marker("red"))
    println(Marker("损色"))
    val m1=new Marker("suisai")
    // 单例函数调用，省略了.(点)符号
    println(Marker.getMarker ("blue"))

  }
}

object Test3{
  def main(args: Array[String]): Unit = {
    println(Marker.getMarker("red"))

    val mi=new Marker("无色")

  }
}
