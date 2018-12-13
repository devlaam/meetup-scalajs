package meetup.demo

import scala.util.{ Success, Failure }
import scala.io.StdIn
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._

/* Starts a webserver on the local host. */
object Main extends App with Routes
{ implicit val system       = ActorSystem(name = "demo")
  implicit val dispatcher   = system.dispatcher
  implicit val materializer = ActorMaterializer()

  val ip    = "127.0.0.1"
  val port  = 8088
  def route = (routeAux ~ routeIndex ~ routeInfo)  

  val binding = Http().bindAndHandle(route, ip, port)

  binding.onComplete
  { case Success(_)     => println("Bind Complete")
    case Failure(error) => println(s"Bind Failed: ${error.getMessage}") }

  while (!StdIn.readLine.contains("quit")) {}

  system.terminate }
