package com.cache

import java.util.concurrent.ConcurrentHashMap


object Demo extends App {
  var cs = CacheSystem

  def gettime(i:Int): ConcurrentHashMap[String, Any] = {
    var m = new ConcurrentHashMap[String, Any]()
    m.put("time", System.currentTimeMillis()/i)
    m
  }

  var cc = cs.addCache("cacheOne", 5, 20, 3, gettime(1000))
  cc.putValue("time", Some(List(1, 2, 3)))

  var cache = cs.getCache("cacheOne")

  println(cc==cache)
  var f: Any = ""
  cache.getValue("time")

  var count=0
  while (f != None) {
    Thread.sleep(200)
    f = cache.getValue("time")
    println("value:"+f)
    count=count+1
    if(count==50){
      cache.putValue("time","主动更新：2018.1.1")
    }

  }
  Thread.sleep(1000)
  cs.getCache("cacheOne")
}