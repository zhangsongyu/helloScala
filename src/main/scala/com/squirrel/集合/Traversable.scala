package com.squirrel.集合

import java.io.IOException

import scala.collection.mutable


class Traversable {

}

object TestTraversable {
  def main(args: Array[String]): Unit = {
    var xs = Traversable(1, 2, 3, 4, 5)
    var ys = Traversable(6, 7, 8, 9)
    //循环
    xs foreach { x => x * 10; println(x) }
    //运算
    println(xs ++ ys)
    //map
    println(xs.map(x => x + 1))

    val nestedNumbers = List(List(1, 2), List(3, 4))
    println(nestedNumbers.flatMap(x => x.map(_ * 2)))

    var strSeq = "q,w,e,r,t" :: "1,2,3,4,5" :: Nil
    var fss = strSeq.flatMap(x => x.split(","))
    println(fss)

    //通过对每个xs中的符合定义的元素调用偏函数f，并把结果收集起来生成一个集合。
    println(xs collect {
      case 2 => 2 * 2
      case 3 => 3 * 3
    })

    //转换
    xs.toArray
    xs.toArray
    xs.toList
    xs.toIterable
    xs.toSeq
    xs.toIndexedSeq //把容器转换为一个索引序列
    xs.toStream //把容器转换为一个延迟计算的流。
    xs.toSet //把容器转换为一个集合（Set）。

    xs.filter(p => p > 10)


    //子容器

    println(xs takeWhile (p => p < 3)) //获取前缀
    println(xs dropWhile (p => p < 3))


    //  拆分
    var lis = xs splitAt 3
    println(lis._1 ++ lis._2) //把xs从指定位置的拆分成两个容器（xs take n和xs drop n）。

    println(xs span (p => p < 3)) //根据一个断言p将xs拆分为两个容器（xs takeWhile p, xs.dropWhile p）。

    println(xs partition (p => p % 2 == 0))


    //条件元素
    println(xs forall (p => p % 2 == 0))
    println(xs exists (p => p % 2 == 0))
    println(xs count (p => p % 2 == 0))

    //折叠12345
    var lrf = (0 /: xs) (
      (x, y) => {
        println(x + " " + y);
        x + y;
      })
    var rlf = (xs :\ 15) ((x, y) => {
      println(x + " " + y);
      y - x
    })

    // xs.foldLeft(z)(op)	与(z /: xs)(op)相同。
    //xs.foldRight(z)(op)	与 (xs :\ z)(op)相同。
    //特殊折叠
    println(xs.sum + "  " + xs.product + "  " + xs.min)


    //字符串
    var sb = new StringBuilder()
    println(xs.addString(sb))

    println(xs.mkString("start", "^^", "end"))
    println(xs.stringPrefix)

    //    视图

    println(xs.view(1, 3))

    //
    var itxs = xs.toIterator
    while (itxs.hasNext) {
      print(itxs.next())
    }
    println("------")

    //zip
    var xyz = xs.toIterator zip ys.toIterator
    while (xyz.hasNext) {
      println(xyz.next())
    }

  }


}