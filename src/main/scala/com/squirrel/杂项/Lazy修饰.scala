package com.squirrel.杂项

class Lazy修饰 {

}
class Foo{
  lazy val text=io.Source.fromFile("/etc/passwd").getLines().foreach(println)
}
object TestFoo extends App{
  val f=new Foo
 var t= f.text
  println ("GETLINE")
  println(t)

}