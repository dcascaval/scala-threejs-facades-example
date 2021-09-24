package example

import scala.scalajs.js
import org.scalajs.dom.{document, window}

import typings.three.cameras.PerspectiveCamera
import typings.three.geometries.BoxGeometry
import typings.three.materials.MeshBasicMaterial
import typings.three.objects.Mesh
import typings.three.renderers.WebGLRenderer
import typings.three.scenes.Scene

object Basic:

  def run() =
    // Create an empty scene
    val scene = new Scene();

    // Create a basic perspective camera
    var camera = new PerspectiveCamera(
      75,
      window.innerWidth / window.innerHeight,
      0.1,
      1000
    );
    camera.position.z = 4;

    // Create a renderer with Antialiasing
    var renderer = new WebGLRenderer(new { antialias = true });

    // Configure renderer clear color
    renderer.setClearColor("#000000");

    // Configure renderer size
    renderer.setSize(window.innerWidth, window.innerHeight);

    // Append Renderer to DOM
    document.body.appendChild(renderer.domElement);

    // Create a Cube Mesh with basic material
    val geometry = new BoxGeometry(1, 1, 1);
    val material = new MeshBasicMaterial(new { color = "#433F81" });
    val cube = new Mesh(geometry, material);

    // Add cube to Scene
    scene.add(cube);

    // Render Loop
    def render(t: Double): Unit = {
      window.requestAnimationFrame(render(_));

      cube.rotation.x += 0.01;
      cube.rotation.y += 0.01;

      // Render the scene
      renderer.render(scene, camera);
    }

    render(0.0)

object Main extends App {
  println("Hello world!!")

  // Since the script loads in the header of the HTML file, wait until the document loads
  // to start modifying the DOM.
  document.addEventListener(
    "DOMContentLoaded",
    _ => Basic.run()
  )
}
