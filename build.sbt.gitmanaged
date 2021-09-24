// Add a dependency on this project via git.
lazy val threeTypes = RootProject(
  uri("https://github.com/dcascaval/scala-threejs-facades.git")
)

// BASE SBT / SCALA3 / SCALAJS PROJECT SETUP
lazy val root = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .dependsOn(threeTypes)
  .settings(
    name := "example",
    scalaVersion := "3.0.0",
    scalacOptions ++= Seq("-Yresolve-term-conflict:package"),

    // Add SJS dom, which we need generally for DOM APIs
    libraryDependencies ++= Seq(
      ("org.scala-js" %%% "scalajs-dom" % "1.2.0")
        .cross(CrossVersion.for3Use2_13)
    ),

    // This is a top-level application with a SJS main method
    scalaJSUseMainModuleInitializer := true,
    // Provide a js environment for DOM access in run and test.
    jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv()
  )
