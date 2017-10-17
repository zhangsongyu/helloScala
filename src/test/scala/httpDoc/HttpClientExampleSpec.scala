package httpDoc

class HttpClientExampleSpec {

}
object Hces extends App{
//  "manual-entity-consume-example-1" in compileOnlySpec {
    //#manual-entity-consume-example-1
    import java.io.File

    import akka.actor.ActorSystem
    import akka.http.scaladsl.model._
    import akka.stream.ActorMaterializer
    import akka.stream.scaladsl.{ FileIO, Framing }
    import akka.util.ByteString

    implicit val system = ActorSystem()
    implicit val dispatcher = system.dispatcher
    implicit val materializer = ActorMaterializer()

    val response: HttpResponse = HttpResponse(entity =HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Say hello to akka-http</h1>") )

    response.entity.dataBytes
      .via(Framing.delimiter(ByteString("\n"), maximumFrameLength = 256))
      .map(transformEachLine)
      .runWith(FileIO.toPath(new File("./Users/zhangsongyu/IdeaProjects/helloScala/target/example.out").toPath))

    def transformEachLine(line: ByteString): ByteString = response.toString().getBytes("utf-8").asInstanceOf[ByteString]

    //#manual-entity-consume-example-1
}

//"manual-entity-consume-example-2" in compileOnlySpec
object Hces1 extends App{
  //#manual-entity-consume-example-2
  import scala.concurrent.Future
  import scala.concurrent.duration._

  import akka.actor.ActorSystem
  import akka.http.scaladsl.model._
  import akka.stream.ActorMaterializer
  import akka.util.ByteString

  implicit val system = ActorSystem()
  implicit val dispatcher = system.dispatcher
  implicit val materializer = ActorMaterializer()

  case class ExamplePerson(name: String)
  def parse(line: ByteString): ExamplePerson = ExamplePerson("zsy")

  val response: HttpResponse = HttpResponse(entity = HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Say hello to akka-http</h1>"))

  // toStrict to enforce all data be loaded into memory from the connection
  val strictEntity: Future[HttpEntity.Strict] = response.entity.toStrict(3.seconds)

  // while API remains the same to consume dataBytes, now they're in memory already:
  val transformedData: Future[ExamplePerson] =
  strictEntity flatMap { e =>
  e.dataBytes
  .runFold(ByteString.empty) { case (acc, b) => acc ++ b }
  .map(parse)
}
println(transformedData)
  //#manual-entity-consume-example-2
}