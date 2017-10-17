package com.akkaHttp.fileDownload

import java.io.FileInputStream
import java.net.URLEncoder

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.model.headers.ContentDispositionTypes.{attachment}
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

import scala.io.StdIn


object WebServer {
  def main(args: Array[String]) {
    implicit val system = ActorSystem("my-system")
    implicit val materializer = ActorMaterializer()
    // needed for the future flatMap/onComplete in the end
    implicit val executionContext = system.dispatcher

    val in = Some(new FileInputStream("/Users/zhangsongyu/IdeaProjects/helloScala/src/main/scala/com/squirrel/输入输出/文件处理/picture.jpg"))
    var b = new Array[Byte](1024 * 16)
    try {
      in.get.read(b)
    }
    finally {
      if (in.isDefined) in.get.close()
    }

    val route =
      path("showPic") {
        get {
          complete(HttpResponse(entity =
            HttpEntity(ContentType(MediaTypes.`image/jpeg`), b)))
        }


      } ~
        path("downloadPic") {
          //设置文件名
          var h = headers.`Content-Disposition`(attachment, Map("filename"->URLEncoder.encode("湖泊.jpg","utf-8")))
          get {
            complete(HttpResponse(headers = List(h), entity = HttpEntity(ContentType(MediaTypes.`multipart/form-data`), b)))
          }
        } ~
        path("downloadPdf") {
          get {
            complete(HttpEntity(ContentType(MediaTypes.`multipart/form-data`), b))
          }
        }

    val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)

    println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done
  }
}