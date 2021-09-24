package example

import org.scalajs.dom.document

object Main extends App {
  println("Hello world!")

  // Since the script loads in the header of the HTML file, wait until the document loads
  // to start modifying the DOM.
  document.addEventListener(
    "DOMContentLoaded",
    _ =>
      val p = document.createElement("p")
      p.innerHTML = "Hello World!"
      document.body.appendChild(p)
  )
}
