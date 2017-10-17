package com.squirrel.特征.pctest

case class Child() extends Parent {
  override def say(): Unit = {
    super.say()
  }

  super.say()
}

object TestPc extends App {
  Child().say()
  Child().years()
  val c = Child()
  c.say()

}