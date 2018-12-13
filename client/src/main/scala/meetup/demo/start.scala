package meetup.demo

import org.scalajs.dom
import dom.{ document, Event }
import scalatags.JsDom.all._
import akka.actor.ActorSystem


object Main
{ val startBtn = button(`type`:="button")("Get me updates.").render
  val stopBtn  = button(`type`:="button")("Cancel updates.").render

  val system    = ActorSystem("demo")
  val dataActor = system.actorOf(DataActor.props)

  startBtn.onclick = ( (_:Event) => dataActor ! DataActor.Start )
  stopBtn.onclick  = ( (_:Event) => dataActor ! DataActor.Stop  )

  def main(args: Array[String])
  { Notifier.checkAndRequest
    document.body.appendChild(startBtn)
    document.body.appendChild(stopBtn) } }
