package com.squirrel.集合

import scala.collection.mutable

class TestJihe {

}

class People(var pAge: Int) {
  var age: Int = pAge
}

/**
  * 通过他们的age（年龄）把这个集合people拆分到到miors（未成年人）和adults（成年人）中。
  * 由于这个拆分方法是被定义在根集合类型TraversableLike类中，这部分代码服务于任何类型的
  * 集合，包括数组。例子运行的结果就是miors和adults集合与people集合的类型相同
  */
object TC1 {
  def main(args: Array[String]): Unit = {
    var li = List(new People(10), new People(15), new People(20))


    val (minors, adults) = li partition (_.age < 18)
    val (minors1, adults1) = li.partition(_.age < 18)
println("有限？"+li.hasDefiniteSize)
    println((minors, adults))
  }
}