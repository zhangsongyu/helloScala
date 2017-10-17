class C{
  var name=""

}
object C{
  def say():Unit={println("object_C")}
}
class TestC extends App{
  var c=new C

}