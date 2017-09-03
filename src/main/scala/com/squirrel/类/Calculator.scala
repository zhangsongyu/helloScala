package com.squirrel.类

class Calculator(brand: String) {
  /**
    * A constructor.
    */
  var color: String = {
    if (brand == "TI") {
      "blue"
    } else if (brand == "HP") {
      "black"
    } else {
      "white"
    }
  }

  def apply(brand: String, times: Int): Calculator = {
    println(times)
  var c=  new Calculator(brand)
    c.color="sunsai"
    c
  }
  def apply( words: String): Calculator = {
   color="sunsai1"
    this
  }
  def getColor: String = color

  // An instance method.
  def add(m: Int, n: Int): Int = m + n
}

object Test {
  def main(args: Array[String]): Unit = {
    var c = new Calculator("TI")
    println(c.getColor)
   var c1= c("ads", 0)
    println(c1.getColor)
    println(c.getColor)

    c("sunse")
    println(c.getColor)

  }

}