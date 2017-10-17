package com.squirrel.杂项

class T1 {

}

object T1 {
  def main(args: Array[String]): Unit = {
    def f1(x: Int): Int = {
      x * 10
      6
    }

   println( f1(1))
  }
}
object Test2 {
  def main(args: Array[String]) {
    val buf = new StringBuilder;

    buf ++= "bcdef"
    println( "buf is : " + buf.toString );
  }
}

object Test7 {
  def main(args: Array[String]) {
    val sites = Map("runoob" -> "www.runoob.com", "google" -> "www.google.com")

    println("show(sites.get( \"runoob\")) : " +
      show(sites.get( "runoob")) )
    println("show(sites.get( \"baidu\")) : " +
      show(sites.get( "baidu")) )
  }

  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }
}