package com.squirrel.函数

import java.util.Date

class 便应用函数 {

}

object Test6 {
  def main(args: Array[String]) {
    val date = new Date
    log(date, "message1" )
    Thread.sleep(1000)
    log(date, "message2" )
    Thread.sleep(1000)
    log(date, "message3" )
  }

  def log(date: Date, message: String)  = {
    println(date + "----" + message)
  }
}

object Test7 {
  def main(args: Array[String]) {
    val date = new Date
    val logWithDateBound = log(date, _ : String)

    logWithDateBound("message1" )
    Thread.sleep(2000)
    logWithDateBound("message2" )
    Thread.sleep(2000)
    logWithDateBound("message3" )
  }

  def log(date: Date, message: String)  = {
    println(date.hashCode() + "----" + message)
  }
}
