package com.squirrel.输入输出.yieldDemo

object YieldDemo {
  private val files = new java.io.File("/Users/zhangsongyu/IdeaProjects/helloScala/src/main/scala/com/squirrel/输入输出/yieldDemo").listFiles

  private def fileLines(file: java.io.File) =
    scala.io.Source.fromFile(file).getLines.toList

  def main(args: Array[String]): Unit = {
    val lineLengths =
      for {
        file <- files
        if file.getName.endsWith(".txt")

        line <- fileLines(file)
        trimmedLine = line.trim
        if trimmedLine.matches(".*棒.*")
      } yield
        line + "：合计" + trimmedLine.length + "个字。"

    lineLengths.foreach(println)
  }
}

object Demo2 {
  def main(args: Array[String]): Unit = {
    val a = Array(1, 2, 3, 4, 5)
    var y = for (e <- a) yield e * 2

    var y1 = for (e <- a
                  if e > 2) yield e * 2

    var y2 = for (e <- a
                  ) yield e * 2


    println(y)
  }
}