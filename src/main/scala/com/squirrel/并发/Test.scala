package com.squirrel.并发

import java.util.concurrent.Callable

object TestRunable{
  def main(args: Array[String]): Unit = {
    new Thread(() => {
      var i=0
      while (i<10){
        println(i)
        i+=1
      }
    }).start()
  }
}



