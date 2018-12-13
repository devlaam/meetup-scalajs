enablePlugins(ScalaJSPlugin)

scalaVersion := "2.12.7" 

name := "MeetupDemo" 

libraryDependencies ++= Seq( 
  "org.scala-js"   %%% "scalajs-dom"      % "0.9.6",
  "be.doeraene"    %%% "scalajs-jquery"   % "0.9.3",
  "com.lihaoyi"    %%% "scalatags"        % "0.6.7" )
  
  
/* Choose Show1 .. Show5 here, do not forget to clean, reload, fastOpt  
   Open the corresponding html file in your browser. Make sure the cache is well(!) cleaned. */  
mainClass in Compile := Some("meetup.demo.Show1") 

scalaJSUseMainModuleInitializer := true


