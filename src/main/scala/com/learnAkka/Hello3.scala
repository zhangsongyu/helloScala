package com.learnAkka

import akka.actor.{Actor, ActorRef, ActorSystem, Kill, Props}

object Hello3 extends App {

  import Greeter._

  val system = ActorSystem("actor-demo-scala")
  val bob = system.actorOf(props("Bob", "Howya doing"), "Bob")
  val alice = system.actorOf(props("Alice", "Happy to meet you"), "Alice")
  bob ! Greet(alice)

  alice ! Greet(bob)

  //前缀：／user
  system.actorSelection("/user/Bob") ! Greet(alice)

  Thread sleep 1000


  //  system terminate

  //异步操作，不会立刻停止
  // system.stop(bob)

  //  Thread sleep 1000
  bob ! Kill

  bob ! Greet(alice)


  object Greeter {

    case class Greet(peer: ActorRef)

    case object AskName

    case class TellName(name: String)

    def props(name: String, greeting: String) = Props(new Greeter(name, greeting))
  }

  class Greeter(myName: String, greeting: String) extends Actor {

    import Greeter._

    def receive: PartialFunction[Any, Unit] = {
      case Greet(peer) => peer ! AskName
      case AskName =>
        sender ! TellName(myName)
      case TellName(name) => println(s"$greeting, $name")
    }
  }

}
