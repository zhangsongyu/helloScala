package com.learnAkka

import akka.actor._
import akka.util._
import com.learnAkka.Hello3.Greeter.Greet
import com.learnAkka.Hello3.{alice, system}

import scala.concurrent.Future

/** Simple hello from an actor in Scala. */
object Hello1 extends App {

  val system = ActorSystem("actor-demo-scala")
  val hello = system.actorOf(Props[Hello], "helloActor")
  var i = 0
  import scala.concurrent.ExecutionContext.Implicits.global
  Future(
    while (i < 1000) {
      i += 1
      system.actorSelection("/user/helloActor") ! i
    }
  )
  Future(
    while (i < 1000) {
      i += 1
      system.actorSelection("/user/helloActor") ! i
    }
  )
  hello ! "Bob"
  Thread sleep 1000
  system.terminate()

  class Hello extends Actor {
    def receive: PartialFunction[Any, Unit] = {
      case name: String => println(s"Hello $name")
      case number: Int => println(s"Hello $number")

    }
  }

}