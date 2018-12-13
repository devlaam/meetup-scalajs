package meetup.demo

import scalatags.Text.all._

object Index
{ private val defer   = attr("defer").empty
  private val jscript = `type`:="text/javascript"
  
  val jQuerySource = "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"
  val scriptSource = "aux/meetupclient-fastopt.js"

  val site = html(
    head(
      script(defer, jscript, src:=jQuerySource),
      script(defer, jscript, src:=scriptSource)),
    body(
      div(
        h1(id:="title", "Meetup Demo") ) ) ) }
