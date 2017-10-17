package com.squirrel.函数

class 匿名函数 {

}

object 匿名函数 {
  def main(args: Array[String]): Unit = {
    val f = (i: Int) => {
      i % 2 == 0
    }

    val f1: (Int) => Boolean = i => {
      i % 2 == 0
    }
    val f2: Int => Boolean = i => {
      i % 2 == 0
    }

    val f3: (Int) => Boolean = i => i % 2 == 0

    val f4: (Int) => Boolean = _ % 2 == 0




  }
}