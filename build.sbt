import sbt.{Credentials, Path, Resolver}

name := """akka-play-prototype"""
organization := "org.talend"

version := "1.0-SNAPSHOT"

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(resolvers ++= Seq(
    "Talend Releases" at "https://artifacts-zl.talend.com/nexus/content/repositories/releases"))

scalaVersion := "2.12.6"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.13"
libraryDependencies += ws
libraryDependencies += "com.typesafe.akka" %% "akka-remote" % "2.5.14"
libraryDependencies += "com.typesafe.akka" %% "akka-cluster" % "2.5.14"
libraryDependencies += "com.typesafe.akka" %% "akka-cluster-tools" % "2.5.14"
libraryDependencies += "de.heikoseeberger" %% "constructr" % "0.19.0" % Runtime
libraryDependencies += "com.lightbend.constructr" %% "constructr-coordination-zookeeper" % "0.4.1" % Runtime

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "org.talend.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "org.talend.binders._"
