package meetup.demo

import scala.scalajs.js
import scala.collection.mutable.Map
import org.scalajs.dom
import org.scalajs.jquery.jQuery
import dom.{ document, Event }
import scalatags.JsDom.all._
import js.Dynamic.literal

/* Open the file show5.html in your browser. 
 * Shows the use of jQuery. */
object Show5
{ val aniTime = 2000
  val btn     = button(id:="btnMover", `type`:="button" )("Click Me").render

  /* Select one of these, not all of them work. The disadvantage of working untyped. */
  btn.onclick = ( (_:Event) => jQuery(btn).animate(literal(width = 300),aniTime)            )
  btn.onclick = ( (_:Event) => jQuery(btn).animate(literal(width = "300px"),aniTime)        )
  btn.onclick = ( (_:Event) => jQuery(btn).animate(js.Dictionary("width" -> "300"),aniTime) )
  btn.onclick = ( (_:Event) => jQuery(btn).animate(Map("width" -> "300"),aniTime)           )

  def main(args: Array[String])
  { document.body.appendChild(btn) } }
