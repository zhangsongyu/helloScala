package com.cache

class CacheConfiguration(var name: String, var size: Int) {
  var timeTodleSeconds: Long =CS.DEFAULT_TIMETODEL_SEC
  var updateIntervalSec: Long = CS.DEFAULT_UPDATE_INTERVALSEC

  def setTimeTodleSeconds(timeTodleSeconds: Long
                         ): Unit = {
    this.timeTodleSeconds = timeTodleSeconds
  }

  def updateIntervalSec(updateIntervalSec: Long): Unit = {
    this.updateIntervalSec = updateIntervalSec
  }
}
