package com.squirrel.并发

import java.util.concurrent.TimeUnit

import scala.concurrent.duration.Duration._
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.util.{Failure, Random, Success}

class TestFuture1() {


}

object TestFuture1 extends App {

  implicit val baseTime: Long = System.currentTimeMillis()

  val f = Future[Int] {
    Thread sleep 500
    1 + 1
  }


  val result = Await.result(f, Duration(1, TimeUnit.SECONDS))

  println(result)

  Thread sleep 1000
}

//使用回调
object TestFuture1WithCallbck extends App {
  println("Start...")
  val f = Future[Int] {
    Thread sleep Random.nextInt(500)
    42
  }
  println("brfore Complete")
  f.onComplete {
    case Success(value) => println(s"got the callback,value is:$value")
    case Failure(e) => e.printStackTrace()
  }

  Thread sleep 1000
}

//返回Future[T]
object TestFutureT extends App {
  println("Start...")

  def getFuture(i: Int): Future[Int] = Future[Int] {
    Thread sleep Random.nextInt(500)
    i
  }

  println("brfore Complete")
  getFuture(66).onComplete {
    case Success(value) => println(s"got the callback,value is:$value")
    case Failure(e) => e.printStackTrace()
  }

  Thread sleep 1000


  println("end...")

}

//链接Future
object TestContactFuture extends App {

  val f1 = Future[Int] {
    Thread sleep Random.nextInt(500)
    11
  }
  val f2 = Future[Int] {
    Thread sleep Random.nextInt(500)
    22
  }
  val f3 = Future[Int] {
    Thread sleep Random.nextInt(500)
    33
  }

  val result = for {
    r1 <- f1
    r2 <- f2
    r3 <- f3

  } yield r1 + r2 + r3


  println(result)
  result foreach(f=>println(f))


  result.onComplete {
    case Success(total) => println(total)
  }
  Thread sleep 1000


}