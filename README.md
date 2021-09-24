This is a fully contained starter example of using [scala-threejs-facades](https://github.com/dcascaval/scala-threejs-facades) in a project. There are two ways to use this project:

1. Clone the facades repo, run `sbt publishLocal` from the root directory, adjusting the version referenced in `build.sbt` here to the version that was cloned.

2. Allow SBT to resolve the dependency on its own (replace `build.sbt` with `build.sbt.gitmanaged`). Note that this is unsupported by bloop [issue](https://github.com/scalacenter/bloop/issues/1373), and so `sbt bloopInstall` will fail when importing a build into e.g. Metals on VSCode. However, normal sbt builds work fine.
