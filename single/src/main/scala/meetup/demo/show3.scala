package meetup.demo

import org.scalajs.dom
import dom.{ document, Event }
import dom.raw.{ HTMLParagraphElement, HTMLButtonElement }
import scala.scalajs.js.annotation.JSExportTopLevel


/* Open the file show3.html in your browser. 
 * Show two methods of event handling */
object Show3
{ private val p      = document.querySelector("#idShow").asInstanceOf[HTMLParagraphElement]
  private val button = document.querySelector("#btnFacade").asInstanceOf[HTMLButtonElement]

  @JSExportTopLevel("onClick")
  def onClick() = { p.textContent = "Clicked Intrude" }

  button.onclick     = ( (_:Event) => p.textContent = "Clicked Facade" )

  def main(args: Array[String]) {} }

