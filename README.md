This is a fully contained starter example of using [scala-threejs-facades](https://github.com/dcascaval/scala-threejs-facades) in a project.

To run: 
```
sbt 
> ~fastOptJS/webpack
```

and serve the `index.html` file or open it in a browser.

This will generate a library bundle, and webpack will run only on the code in your project (i.e. not all of `THREE`) on file changes. Note that when releasing code, we should use `fullOptJS/webpack`, which will use ScalaJS's full optimizer as well as webpack's production mode. In this case you should comment out `webpackBundlingMode := BundlingMode.LibraryOnly()` in `build.sbt`, and adjust `index.html` to include the single bundle instead of the library bundles accordingly.