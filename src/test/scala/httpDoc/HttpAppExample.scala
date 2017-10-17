package httpDoc

class HttpAppExample {

}

//#with-actor-system-settings
import akka.actor.ActorSystem
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.HttpApp
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.settings.ServerSettings
import com.typesafe.config.ConfigFactory

// Server definition
object WebServer extends HttpApp with App {
  override def routes: Route =
    path("hello") {
      get {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Say hello to akka-http</h1>"))
      }
    }


  // Starting the server
  val system = ActorSystem("ownActorSystem")
  val settings = ServerSettings(ConfigFactory.load).withVerboseErrorMessages(true)
  WebServer.startServer("localhost", 8080, settings, system)
  system.terminate()
  //#with-actor-system-settings

}

//minimal-routing-example self destroying in 5 seconds
//#override-termination-signal
import akka.Done
import akka.actor.ActorSystem
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.HttpApp
import akka.pattern
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.settings.ServerSettings
import com.typesafe.config.ConfigFactory
import scala.concurrent.duration._
import scala.concurrent.{ExecutionContext, Future}
import scala.language.postfixOps

// Server definition
object WebServer1 extends HttpApp with App {
  override def routes: Route =
    path("hello") {
      get {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Say hello to akka-http</h1>"))
      }
    }

  override def waitForShutdownSignal(actorSystem: ActorSystem)(implicit executionContext: ExecutionContext): Future[Done] = {
    pattern.after(5 seconds, actorSystem.scheduler)(Future.successful(Done))
  }


  // Starting the server
  WebServer1.startServer("localhost", 8080, ServerSettings(ConfigFactory.load))
  //#override-termination-signal
}


//stopping-system-on-shutdown" in compileOnlySpec {
//#cleanup-after-shutdown
import akka.Done
import akka.actor.ActorSystem
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.HttpApp
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.settings.ServerSettings
import scala.util.Try
import com.typesafe.config.ConfigFactory

// Server definition
object WebServer2 extends HttpApp with App {
  override def routes: Route =
    path("hello") {
      get {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Say hello to akka-http</h1>"))
      }
    }

  private def cleanUpResources(): Unit = ???

  override def postServerShutdown(attempt: Try[Done], system: ActorSystem): Unit = {
    cleanUpResources()
  }


  // Starting the server
   WebServer2.startServer("localhost", 8080, ServerSettings(ConfigFactory.load))
  //#cleanup-after-shutdown
}