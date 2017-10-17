package com.cache

import scala.collection.mutable

class CacheManager() {
  var nameToCacheMap = mutable.HashMap.empty[String, Cache]

  def addCache(cache: Cache): Option[Cache] = {
    nameToCacheMap.put(cache.cacheName, cache)
  }

  def getCache(cacheName: String): Cache = {
    val cache = nameToCacheMap.get(cacheName) match {
      case Some(cache) => {
        cache
      }
      case None => throw new Exception("Cache不存在")
    }
    cache
  }

  def updateCache(cacheName: String, cache: Cache): Unit = {
    nameToCacheMap.update(cacheName, cache)
  }

  def removeCache(cacheName: String): Unit = {
    nameToCacheMap.remove(cacheName)
  }

}
