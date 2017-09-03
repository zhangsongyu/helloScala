package com.squirrel.异常

import java.io.{FileNotFoundException, FileReader, IOException}

/**
  * Created by Administrator on 2017/9/1.
  */
object Test {
  def main(args: Array[String]) {
    try {
      val f = new FileReader("input.txt")
    } catch {
      case e: FileNotFoundException =>{
        println(e+" Missing file exception")
      }
      case e: IOException => {
        println(e+" IO Exception")
      }
    } finally {
      println("Exiting finally...")
    }
  }
}
