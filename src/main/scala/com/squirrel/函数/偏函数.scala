package com.squirrel.函数

class 偏函数 {

}

object 偏函数 {
  def main(args: Array[String]): Unit = {
    val one: PartialFunction[Any, String] = {
      case 1 => "one"
      case str:String=>"String type"

    }

    one.isDefinedAt(1)


    one.isDefinedAt(2)
    println(one(1))
    println(one("2"))
    println(one(3))

  }
}

case class PhoneExt(name: String, ext: Int)

//filter使用一个函数。在这个例子中是一个谓词函数(PhoneExt) => Boolean。
object TestCase {
  def main(args: Array[String]): Unit = {
    val extensions = List[PhoneExt](PhoneExt("steve", 100), PhoneExt("robey", 200))
    extensions.filter { case PhoneExt(name, extension) => extension < 200 }
    //    extensions.filter { x=> x.extension < 200 }

  }
}
