package com.squirrel.类

class 构造器 {

}
class Student(id:Int, name:String){
  var age:Int = 0
  def showDetails(){
    println(id+" "+name+" "+age)
  }
  def this(id:Int, name:String,age:Int){
    this(id,name)
    if (age<0)this.age=1
    else // Calling primary constructor, and it is first line
    this.age = age
  }
}

object Demo{
  def main(args:Array[String]){
    var s = new Student(1010,"Maxsu", -1);
    s.showDetails()
  }
}
