lazy val baseSettings = Seq(
  scalaVersion := "2.12.6",
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)

lazy val module1 = (project in file("module1"))
  .settings(baseSettings)
  .settings(name := "module2")

lazy val module2 = (project in file("module2"))
  .settings(baseSettings)
  .settings(name := "module1")

lazy val multiModule = (project in file("."))
  .aggregate(module1, module2)
  .settings(name := "sbt-multi-module")
  .settings(baseSettings)
