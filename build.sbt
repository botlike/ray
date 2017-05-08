name := "ray"

version := "1.0"

scalaVersion := "2.12.2"

val akkaVersion = "2.5.1"

libraryDependencies ++= Seq("com.typesafe.akka" %% "akka-actor" % akkaVersion,
                            "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
                            "com.typesafe.akka" %% "akka-cluster-sharding" % akkaVersion)
        