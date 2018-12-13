package meetup.demo
import scala.scalajs.js
import js.annotation.JSGlobal
import org.scalajs.dom.raw.{Event, MouseEvent}
import org.scalajs.jquery.jQuery

/* See for more information how this notification object works:
 * https://developer.mozilla.org/en-US/docs/Web/API/Notification/requestPermission */
@js.native
@JSGlobal("Notification")
class Notification(title: String, options: js.Any) extends js.Object
{ val permission: String                    = js.native
  var onshow:  js.Function1[MouseEvent, _]  = js.native
  var onclick: js.Function1[MouseEvent, _]  = js.native
  var onclose: js.Function1[Event, _]       = js.native
  var onerror: js.Function1[Event, _]       = js.native
  def close(): Unit                         = js.native
  def requestPermission(callback: js.Function1[String, _]): Unit = js.native  }


object Notifier
{ private val ntfDyn = js.Dynamic.global.Notification
  private val ntfOpt = if ( js.isUndefined(ntfDyn) ) None else Some(ntfDyn.asInstanceOf[Notification])
  private val awnser = (res: String) => println(s"Notification Permission is: $res")

  val isDefined = ntfOpt.isDefined

  def checkAndRequest 
  { for { ntf <- ntfOpt if ntf.permission == "default" } 
    yield ntf.requestPermission(awnser) }

  def sendNotification(title: String, body: String)
  { for { ntf <- ntfOpt if ntf.permission == "granted" } 
    yield new Notification(title,js.Dynamic.literal(body=body)) }


}



