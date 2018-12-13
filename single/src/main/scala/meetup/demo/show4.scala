package meetup.demo

import org.scalajs.dom
import dom.{ document, Event }
import scala.scalajs.js.annotation.JSExportTopLevel
import scalatags.JsDom.all._

/* Open the file show4.html in your browser. 
 * Shows a typed way of constructing a html tree. */
object Show4
{ val buttonTag    = button(id:="btnFacade", `type`:="button")("With Scalatags")
  val paraTag      = p()()

  val buttonElm    = buttonTag.render
  val paraElm      = paraTag.render

  buttonElm.onclick = ( (_:Event) => paraElm.textContent = "Clicked Scalatags" )

  def main(args: Array[String])
  { document.body.appendChild(buttonElm)
    document.body.appendChild(paraElm) } }
