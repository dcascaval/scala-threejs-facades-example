// BASE SBT / SCALA3 / SCALAJS PROJECT SETUP
lazy val root = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .enablePlugins(ScalaJSBundlerPlugin)
  .settings(
    name := "example",
    scalaVersion := "3.0.2",

    // Add JS Dependencies
    Compile / npmDependencies ++= Seq(
      "three" -> "0.131.0"
    ),

    // Add Scala dependencies.
    libraryDependencies ++= Seq(
      ("org.scala-js" %%% "scalajs-dom" % "1.2.0")
        .cross(CrossVersion.for3Use2_13),
      "io.github.dcascaval" %%% "scala-threejs-facades" % "0.131.0"
    ),

    // This is a top-level application with a SJS main method
    scalaJSUseMainModuleInitializer := true,
    // Provide a js environment for DOM access in run and test.
    jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv(),

    // Use ScalaJSBundler's library bundling mode, so that we have
    // a fast compile/reload step.
    // NOTE: remove this setting for production/deployment.
    webpackBundlingMode := BundlingMode.LibraryOnly()
  )
