name := "helloScala"

version := "1.0"

scalaVersion := "2.12.3"

lazy val akkaHttpVersion = "10.0.10"
lazy val akkaVersion    = "2.4.19"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.41"
libraryDependencies +="com.typesafe.akka" %% "akka-http-spray-json" % "10.0.10"

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "3.0.3" % "test"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion
)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http"            % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-xml"        % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-stream"          % akkaVersion,

  "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test
)

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.2.1",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.2.1"
)
libraryDependencies ++= Seq(
"com.typesafe.akka" %% "akka-testkit" %akkaVersion % "test"
)
//java
// https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api
libraryDependencies += "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided"

mappings in (Compile, packageBin) ~= { _.filterNot { case (_, name) =>
  Seq("application.conf").contains(name)
}}
