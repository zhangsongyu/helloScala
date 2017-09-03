package com.squirrel.集合

/**
  * Created by Administrator on 2017/9/1.
  */
class SetTest {

}
object set{
  def main(args: Array[String]): Unit = {
    val set = Set(29,1,5,3,7,41,13)
    println(set)

    println(set.getClass.getName) //

    println(set.exists(_ % 2 == 0)) //true
    println(set.drop(2)) //Set(2,3)
  }
}

object Test {
  def main(args: Array[String]) {
    val site = Set("Runoob", "Google", "Baidu")
    val nums: Set[Int] = Set()

    println( "第一网站是 : " + site.head )
    println( "最后一个网站是 : " + site.tail )
    println( "查看列表 site 是否为空 : " + site.isEmpty )
    println( "查看 nums 是否为空 : " + nums.isEmpty )
  }
}

object Test2 {
  def main(args: Array[String]) {
    val site1 = Set("Runoob", "Google", "Baidu")
    val site2 = Set("Faceboook", "Taobao")

    // ++ 作为运算符使用
    var site = site1 ++ site2
    println( "site1 ++ site2 : " + site )

    //  ++ 作为方法使用
    site = site1.++(site2)
    println( "site1.++(site2) : " + site )
  }
}


object Test3 {
  def main(args: Array[String]) {
      val colors1 = Map("red" -> "#FF0000",
        "azure" -> "#F0FFFF",
        "peru" -> "#CD853F")
      val colors2 = Map("blue" -> "#0033FF",
        "yellow" -> "#FFFF00",
        "red" -> "#FF1111")

      //  ++ 作为运算符
      var colors = colors1 ++ colors2
      println( "colors1 ++ colors2 : " + colors )
    println( "colors2 ++ colors1 : " + (colors2 ++ colors1) )

      //  ++ 作为方法
      colors = colors1.++(colors2)
      println( "colors1.++(colors2)) : " + colors )

    }
}



object Test4 {
  def main(args: Array[String]) {
    var sites = Map("runoob" -> "http://www.runoob.com",
      "baidu" -> "http://www.baidu.com",
      "taobao" -> "http://www.taobao.com")

    sites+("epy"->"easipay.net")
    sites.keys.foreach{ i =>
      print( "Key = " + i )
      println(" Value = " + sites(i) )}
  }
}