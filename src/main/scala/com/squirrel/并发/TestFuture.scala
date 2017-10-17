package com.squirrel.并发

import java.util.concurrent.{Callable, FutureTask}

class TestFuture(i: Int) extends Callable[Int] {
  var num = 0

  override def call(): Int = {
    for (x <- 1 to 10) {
      num = num + x
    }
    num
  }


}

object TestFuture {
  def main(args: Array[String]): Unit = {
    var future = new FutureTask[Int](new TestFuture(0))
    val thread=new Thread(future)
    for (x <- 1 to 100) {
      println(Thread.currentThread().getName + " " + x)
      if (x == 50) {
        thread.start()
        println(thread.getName+" "+future.get())

      }
    }

//    println(thread.getName+" "+future.get())
  }
}