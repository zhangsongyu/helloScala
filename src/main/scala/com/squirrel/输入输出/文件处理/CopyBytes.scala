package com.squirrel.输入输出.文件处理

import java.io.{FileInputStream, FileOutputStream}

import scala.collection.mutable.ArrayBuffer


object CopyBytes extends App {
  val in = Some(new FileInputStream("/Users/zhangsongyu/IdeaProjects/helloScala/src/main/scala/com/squirrel/输入输出/文件处理/picture.jpg"))
  val out = Some(new FileOutputStream("/Users/zhangsongyu/IdeaProjects/helloScala/src/main/scala/com/squirrel/输入输出/文件处理/copied.jpg"))
  var b = new Array[Byte](1024*128)
  var count=0;
  try {
    while (in.get.read(b) != -1
    ) {
      out.get.write(b)
      count+=1
    }
  } catch {
    case e: Exception => e.printStackTrace()
  } finally {
    if (in.isDefined) in.get.close()
    if (out.isDefined) out.get.close()
  }
  println(count)
}