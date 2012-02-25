import sbt._
import Keys._

import Dependencies._
import BuildSettings._

object BuildSettings {
  lazy val buildOrganization = "com.github.scf4s"
  lazy val buildVersion      = "0.0.1"
  lazy val buildScalaVersion = "2.9.1"

  lazy val buildSettings = Defaults.defaultSettings ++ Seq (
    organization         := buildOrganization,
    version              := buildVersion,
    scalaVersion         := buildScalaVersion,
    initialCommands      := """import scalax.scf4s._""",
    libraryDependencies ++= Seq ( specs2 )
  )
}

object Scf4sBuild extends Build {
  lazy val root = Project ( "scf4s", file ("."), settings = buildSettings )
}

object Dependencies {
  lazy val specs2 = "org.specs2" %% "specs2" % "1.8.2" % "test"
}
