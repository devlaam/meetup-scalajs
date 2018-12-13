package meetup.demo

import scala.util.Random
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._


trait Routes
{ /* Serves the javascript site for the client. */
  def routeAux = path("aux" / Segment) { name => getFromFile(s"../client/target/scala-2.12/$name") }

  /* Serves the basic index.html site. */
  def routeIndex = path("index.html")
  { get
    { complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, Index.site.render)) } }

  /* Serves the the lucky numbers. */
  def routeInfo = path("info")
  { get
    { val msg = Random.nextInt(100)
      println(s"Got info request, sending lucky number $msg")
      complete(s"Your lucky number is: $msg") } } }

