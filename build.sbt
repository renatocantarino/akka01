ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.6"
val AkkaVersion="2.8.8"

lazy val root = (project in file("."))
  .settings(
    name := "akka-streams"
  )


libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %%  "akka-actor-testkit-typed" % AkkaVersion
)

libraryDependencies ++=Seq(
  "ch.qos.logback" %  "logback-classic" % "1.5.18",
  "com.typesafe.akka" %% "akka-slf4j" % AkkaVersion,

)