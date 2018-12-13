package meetup.demo

import org.scalajs.dom
import dom.document
import dom.raw.HTMLParagraphElement

/* Open the file show2.html in your browser. */
object Show2
{ private val p = document.querySelector("#idShow").asInstanceOf[HTMLParagraphElement]

  def makeList
  { val ul  = document.createElement("ul")
    val li1 = document.createElement("li")
    val li2 = li1.cloneNode(true)
    li1.textContent = "Item1"
    li2.textContent = "Item2"
    ul.appendChild(li1)
    ul.appendChild(li2)
    p.appendChild(ul) }

  def main(args: Array[String])
  { Show2.makeList } }
