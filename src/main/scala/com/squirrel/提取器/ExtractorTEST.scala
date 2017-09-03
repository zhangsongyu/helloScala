package com.squirrel.提取器

/**
  * Created by Administrator on 2017/9/1.
  */

object ExtractorTEST {
  def main(args: Array[String]) {

    println("Apply 方法 : " + apply("Zara", "gmail.com"));
    println("Unapply 方法 : " + unapply("Zara@gmail.com"));
    println("Unapply 方法 : " + unapply("Zara Ali"));

    var et = ExtractorTEST("Zara", "gmail.com")


    var unet = unapply(et)
    println(unet)
  }

  // 注入方法 (可选)
  def apply(user: String, domain: String) = {
    user + "@" + domain
  }

  // 提取方法（必选）
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) {
      Some(parts(0), parts(1))
    } else {
      None
    }
  }
}


object Test1 {
  def main(args: Array[String]) {

    val x = Test1(5)
    println(x)

    x match {
      case Test1(num) => println(x + " 是 " + num + " 的两倍！")
      //unapply 被调用
      case _ => println("无法计算")
    }

  }

  def apply(x: Int) = {
    println("apply")
    x * 2
  }

  /**
    * unapply 用于提取我们指定查找的值，它与 apply 的操作相反。
    * 当我们在提取器对象中使用 match 语句是，unapply 将自动执行
    *
    * @param z
    * @return
    */
  def unapply(z: Int): Option[Int] = {
    if (z % 2 == 0)
    {println("unapply") ;Some(z / 2)}
    else None}
}