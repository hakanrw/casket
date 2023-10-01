val scala3Version = "3.3.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "casket",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test,
    libraryDependencies += "com.lihaoyi" %% "cask" % "0.9.1",
    libraryDependencies += "org.scala-lang" %% "toolkit" % "0.1.7"

  )
