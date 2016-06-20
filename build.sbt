name := "allied.earth"

version := "1.0"

lazy val AlliedEarth = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"
incOptions := incOptions.value.withNameHashing(true)
updateOptions := updateOptions.value.withCachedResolution(cachedResoluton = true)

libraryDependencies ++= Seq( jdbc , cache , ws   , specs2 % Test,
  "org.webjars.bower" % "compass-mixins" % "1.0.2",
  "org.webjars" % "bootstrap" % "4.0.0-alpha.2",
  //angular2 dependencies
  //"org.webjars.npm" % "angular2" % "2.0.0-beta.17",
  "org.webjars.npm" % "zcourts-angular-master" % "2.0.0-rc.2-master",
  "org.webjars.npm" % "systemjs" % "0.19.31",
  "org.webjars.npm" % "angular__common" % "2.0.0-rc.2",
  "org.webjars.npm" % "angular__compiler" % "2.0.0-rc.2",
  "org.webjars.npm" % "angular__core" % "2.0.0-rc.2",
  "org.webjars.npm" % "angular__platform-browser" % "2.0.0-rc.2",
  "org.webjars.npm" % "angular__router" % "3.0.0-alpha.7",
  "org.webjars.npm" % "angular__upgrade" % "2.0.0-rc.2",
  "org.webjars.npm" % "todomvc-common" % "1.0.2",
  "org.webjars.npm" % "rxjs" % "5.0.0-beta.7",
  "org.webjars.npm" % "es6-promise" % "3.1.2",
  "org.webjars.npm" % "es6-shim" % "0.35.0",
  "org.webjars.npm" % "reflect-metadata" % "0.1.3",
  "org.webjars.npm" % "zone.js" % "0.6.12",
  "org.webjars.npm" % "typescript" % "1.9.0-dev.20160516",
  //tslint dependency
  "org.webjars.npm" % "tslint-eslint-rules" % "1.2.0",
  "org.webjars.npm" % "codelyzer" % "0.0.19",
  //test
  "org.webjars.npm" % "jasmine" % "2.4.1" % "test"
)

dependencyOverrides ++= Set(
  "org.webjars.npm" % "minimatch" % "3.0.0",
  "org.webjars.npm" % "glob" % "7.0.3"
)

// the typescript typing information is by convention in the typings directory
// It provides ES6 implementations. This is required when compiling to ES5.
typingsFile := Some(baseDirectory.value / "typings" / "index.d.ts")

// use the webjars npm directory (target/web/node_modules ) for resolution of module imports of angular2/core etc
resolveFromWebjarsNodeModulesDir := true

// use the combined tslint and eslint rules plus ng2 lint rules
(rulesDirectories in tslint) := Some(List(tslintEslintRulesDir.value,ng2LintRulesDir.value))

routesGenerator := InjectedRoutesGenerator



fork in run := true


unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"  
