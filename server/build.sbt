scalaVersion := "2.12.7" 

EclipseKeys.withSource := true

scalacOptions ++= Seq("-feature","-deprecation","-unchecked")

name := "MeetupServer"

libraryDependencies ++= Seq( 
  "com.typesafe.akka"  %% "akka-actor"    % "2.5.13",
  "com.typesafe.akka"  %% "akka-stream"   % "2.5.13",
  "com.typesafe.akka"  %% "akka-http"     % "10.1.3",
  "com.lihaoyi"        %% "scalatags"     % "0.6.7" )

