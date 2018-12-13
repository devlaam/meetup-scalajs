package meetup.demo

import scala.language.postfixOps
import scala.concurrent.duration._
import org.scalajs.dom
import dom.ext.Ajax
import dom.{ document, Event }
import akka.actor.{ Actor, ActorSystem, Props, Cancellable }
import akka.pattern.pipe


object DataActor
{ case object Start
  case object Stop
  case object Call
  case class Answer(content: String)

  def props = Props(new DataActor) }


class DataActor extends Actor
{ import DataActor._
  implicit val ec = context.dispatcher

  val info = "http://localhost:8088/info"

  def caller = context.system.scheduler.schedule(1 second, 10 seconds)(self ! Call)
  def awnser(content: String) { Notifier.sendNotification("From Server",content) }

  def receive: Receive =
  { case Start         => context.become(calling(caller))
    case Answer(text)  => awnser(text) }

  def calling(cancel: Cancellable): Receive =
  { case Stop          => cancel.cancel()
                          context.become(receive)
    case Call          => Ajax get(info) map(result => Answer(result.responseText)) pipeTo self
    case Answer(text)  => awnser(text) } }

