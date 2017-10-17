package com.squirrel.类

class Child( pName: String,  pAge: Int,var pHeigh:Int) extends Parent(pName, pAge) {
  println("childClass Cons")

  override def say():Unit={
    println("chind")
  }
}
object TC{
  var c=new Child("baby",5,90)

  def main(args: Array[String]): Unit = {
    c.pAge=6
    println(c.pHeigh)

  }
}