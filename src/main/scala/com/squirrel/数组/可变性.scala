package com.squirrel.数组

class 可变性 {

}
object CharacterStatus {
  val ERROR_CHARACTER = "error"
  val MANAGEMENT_CHARACTER = "management"
  val CHARACTER_TYPE = List(ERROR_CHARACTER, MANAGEMENT_CHARACTER)

  def main(args: Array[String]): Unit = {
    println(CHARACTER_TYPE.contains(("error")))
  }
}