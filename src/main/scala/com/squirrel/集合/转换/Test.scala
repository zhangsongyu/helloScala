package com.squirrel.集合.转换

import scala.collection.immutable.ListMap

class User (name:String,age:Int){

}
object Test{
  def ccToMap(cc: AnyRef): Map[String, Any] = {
    val result = (ListMap[String, Any]() /: cc.getClass.getDeclaredFields) {
      (map, field) =>
        field.setAccessible(true)
        map + (field.getName -> field.get(cc))
    }
    result
  }

  def main(args: Array[String]): Unit = {
    var r=ccToMap(new User("lisi",7))
    println(r)
  }
}
