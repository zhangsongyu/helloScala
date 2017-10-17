package com.squirrel.输入输出.文件处理


import java.net._
import java.io._

import com.squirrel.输入输出.文件处理.PostUrlBytes.b
import com.squirrel.集合.buffer.TestByte.lbs

import scala.collection.mutable.ListBuffer


object CopyUrlBytes extends App {
  var url = new URL("http://127.0.0.1:9000/api/render?url=http://bing.com&emulateScreenMedia=false")
  var conn = url.openConnection()
  var bfin = conn.getInputStream
  var b = new Array[Byte](1024 * 64)
  val out = Some(new FileOutputStream("/Users/zhangsongyu/IdeaProjects/helloScala/src/main/scala/com/squirrel/输入输出/文件处理/fromUrl.pdf"))
  try {
    while ((bfin.read(b)) != -1
    ) {
      out.get.write(b)
      println(b.foreach(x => print(x)))
    }
  } catch {
    case e: Exception => e.printStackTrace()
  } finally {
    bfin.close()
    if (out.isDefined) out.get.close()

  }
}

object PostUrlBytes extends App {
  var url = new URL("http://127.0.0.1:9000/api/render?url=https://www.baidu.com&emulateScreenMedia=false")
  var conn = url.openConnection().asInstanceOf[HttpURLConnection]
  var bfin = conn.getInputStream
  var b = new Array[Byte](1024 * 100)
  val lb = ListBuffer[Array[Byte]]()
  val out = Some(new FileOutputStream("/Users/zhangsongyu/IdeaProjects/helloScala/src/main/scala/com/squirrel/输入输出/文件处理/fromUrl.pdf"))
  try {
    while (bfin.read(b) != -1
    ) {
      lb += b.clone()
    }
    var res = lb.toList.flatten.toArray

    out.get.write(res)

  } catch {
    case e: Exception => e.printStackTrace()
  } finally {
    bfin.close()
    if (out.isDefined) out.get.close()

  }
}