package com.cache

import java.util.concurrent._

object CacheSystem {

  implicit val cacheManager = new CacheManager

  def addCache(name: String, size: Int,
               timeTodleSeconds: Long = CS.DEFAULT_TIMETODEL_SEC,
               updateIntervalSec: Long, f: => ConcurrentHashMap[String, Any]): Cache = {

    val config = new CacheConfiguration(name, size)
    config.setTimeTodleSeconds(timeTodleSeconds)
    config.updateIntervalSec(updateIntervalSec)
    val cache = new Cache(config, f,cacheManager)
    cacheManager.addCache(cache)
    cache
  }

  def getCache(cacheName: String): Cache = {
    cacheManager.getCache(cacheName)
  }

  def updateCache(cacheName: String, cache: Cache): Unit = {
    cacheManager.updateCache(cacheName, cache)
  }

  def removeCache(cacheName: String): Unit = {
    cacheManager.removeCache(cacheName)
  }


}

object CS {
  val DEFAULT_TIMETODEL_SEC = 86400L // 1 day
  val NEVER_DEL = 0L
  val DEFAULT_UPDATE_INTERVALSEC = 23200L //  day
  val NOT_AUTOUPDATE = null //不自动更新cache
}