enablePlugins(ScalaJSPlugin)

scalaVersion := "2.12.7" 

scalacOptions ++= Seq("-feature","-deprecation","-unchecked")

EclipseKeys.withSource := true

name := "MeetupClient" 

libraryDependencies ++= Seq( 
  "org.scala-js"   %%% "scalajs-dom"      % "0.9.6",
  "be.doeraene"    %%% "scalajs-jquery"   % "0.9.3",
  "org.akka-js"    %%% "akkajsactor"      % "1.2.5.16",  
  "com.lihaoyi"    %%% "scalatags"        % "0.6.7" )
  
scalaJSUseMainModuleInitializer := true

