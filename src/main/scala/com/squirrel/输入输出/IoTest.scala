package com.squirrel.输入输出

import java.io.{File, PrintWriter}

import scala.io.Source

/**
  * Created by Administrator on 2017/9/1.
  */
class IoTest {

}
object Test {
  def main(args: Array[String]) {
    val writer = new PrintWriter(new File("test.txt" ))

    writer.write("菜鸟教程")
    writer.close()
  }
}


object Test1 {
  def main(args: Array[String]) {
    println("文件内容为:" )

    Source.fromFile("test.txt" ).foreach{
      print
    }
  }
}