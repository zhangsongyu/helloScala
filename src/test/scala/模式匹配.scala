/**
  * Created by Administrator on 2017/8/31.
  */
object Test {
  def main(args: Array[String]) {
    println(matchTest(3))
    println(matchTest(2))
println(matchString("a"))
    var x="a"
    x match{
      case "a" =>println("AMatch")
      case "b" =>"B"
      case _ => "many"

    }

  }
  def matchTest(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }

  def matchString(x:String):String=x match{
    case "a" =>"A"
    case "b" =>"B"
    case _ => "many"

  }
}