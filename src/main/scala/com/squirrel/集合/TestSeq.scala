package com.squirrel.集合

class TestSeq {

}
object TestSeq{
  def main(args: Array[String]): Unit = {
    var seq=Seq(1,2,3,4,5,8,6,9)
    println(seq:+6)
    println(0+:seq)
    println(seq)

    println(seq.updated(0,-1))
    println(seq)
   println( seq.patch(1,Seq(6,6,6),4))

    println(seq groupBy(k=>k<3))

    println(seq.isDefinedAt(9))
    println(seq.sorted)
  }
}