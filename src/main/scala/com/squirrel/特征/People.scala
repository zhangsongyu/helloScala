package com.squirrel.特征

trait People {
  def say

  def take
}

class Child extends People {
  override def say: Unit = println("ha")

  override def take: Unit = println("by hands")
}