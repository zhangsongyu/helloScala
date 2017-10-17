package com.cache

import java.util.concurrent.ConcurrentHashMap


 class Cache(config: CacheConfiguration, f: => ConcurrentHashMap[String, Any],  cacheManager: CacheManager) {

  private var mm = new ConcurrentHashMap[String, Any]

  var cacheName = config.name
  var timeTodel = config.timeTodleSeconds * 1000
  var deadline = System.currentTimeMillis() + timeTodel
  var nextUpdateTime = System.currentTimeMillis() + config.updateIntervalSec * 1000

  def getValue(key: String) = {
    mm.get(key) match {
      case value: Object => {

        if (timeTodel != CS.NEVER_DEL && System.currentTimeMillis() > deadline) {
          cacheManager.removeCache(cacheName)
          println("chche被删除")
          None
        }

        else if (f != null && System.currentTimeMillis() > nextUpdateTime) {
          var nut = resetNextUpdateTime
          autoUpdateSelf()
          var t = mm.get(key)
          println("cache自动更新：" + t)
          t
        } else
          value
      }
      case null => None
    }
  }

  def putValue(key: String, value: Any) = {
    mm.put(key, value)
  }

  def autoUpdateSelf() = {
    mm = f
    println("f:" + f)
  }

  def resetNextUpdateTime(): Long = {
    nextUpdateTime = nextUpdateTime + config.updateIntervalSec * 1000
    nextUpdateTime
  }
}
