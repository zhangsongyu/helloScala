package com.util.CopyBean

import scala.collection.immutable.ListMap
import scala.collection.mutable

class BeanCopier {

}

case class PdfConfigReq(paperSize: String, paperOrientation: String, showPageHeader: Int, phLeft: Option[String], phCenter: Option[String], phRight: Option[String], showPageFooter: Int, pfLeft: Option[String], pfCenter: Option[String], pfRight: Option[String], title: Option[String], describe: Option[String], iconPath: String, sourcePath: Option[String], resultPath: Option[String])

case class PdfConfigEntity(id: Long, paperSize: String = "A4", paperOrientation: String = "vertical", showPageHeader: Int, phLeft: Option[String] = Some(""), phCenter: Option[String] = Some("1"), phRight: Option[String] = None, showPageFooter: Int = 0, pfLeft: Option[String] = None, pfCenter: Option[String] = None, pfRight: Option[String] = None, title: Option[String] = None, describe: Option[String] = None, iconPath: String = " ../disk/image/pdflog.png", sourcePath: Option[String] = None, resultPath: Option[String] = None, created: Long, createdBy: Long, updated: Long, updatedBy: Long)

object BeanCopier {
  def ccToMap(cc: AnyRef, tt: AnyRef): Map[String, Any] = {
    val result = (ListMap[String, Any]() /: cc.getClass.getDeclaredFields) {
      (map, field) =>
        field.setAccessible(true)
        map + (field.getName -> field.get(tt))
    }
    result
  }

  def beanCopy[S, T](s: S, t: T): T = {
    val sf = s.getClass.getDeclaredFields.map(f => f.getName).toSet
    val tf = t.getClass.getDeclaredFields.map(f => f.getName).toSet
    val st = sf & tf

    s.getClass.getDeclaredFields.map(f => f.set(f, "haha"))
    t
  }
}

object Demo extends App {
  val s = new PdfConfigReq("A3intersection", "vertical", 0, Some(""), Some(""), Some(""), 0, Some(""), Some(""), Some(""), Some(""), Some(""), "../disk/image/pdflog.png", Some(""), Some(""))
  val t = new PdfConfigEntity(100617225170944L, "", "", 0, Some(""), Some(""), Some(""), 0, Some(""), Some(""), Some(""), Some(""), Some(""), "", Some(""), Some(""), 1507793552239L, 89989362012160L, 1507793552239L, 89989362012160L)
  //  val mresilt = BeanCopier.beanCopy(s, t)
  BeanCopier.ccToMap(s, t)

}

class T(var a: String, val b: String, c: String)

case class TC( a: String, b: String, c: String)

object Demo1 extends App {
 var t= new T("1","2","3")
  var tc= TC("1","2","3")
/*  t.a=""
  t.b
  t.c

  tc.a=""
  tc.b=""
  tc.c=""*/

}