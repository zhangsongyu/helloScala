package com.squirrel.函数

class 函数作为参数 {

}

object 函数作为参数 {
  def main(args: Array[String]): Unit = {
    def exec(f: Int => Unit) = {
      f(10)
    }

    def exec2(f: Int => Int,times:Int) = {
      for(i<- 1 to times){
        println("exec2")
      }
      f(10)
    }
    val plusOne = (i: Int) => {
      println(i + 1)
    }


    val plusTwo = (i: Int) => {
      i + 2
    }

    exec(plusOne)

    println(exec2(plusTwo,2))
  }
}