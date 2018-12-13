# Intro in Scala.js, slides and live code

This repro contains the slides of the talk I gave in the Scala Meetup from 12 December 2018. Feel free to use at in your projects. Contains three repro's. Use fastOptJS to compile.

## Single

Five very, very basic examples to get Scala JS going and make some use of [ScalaTags](http://www.lihaoyi.com/scalatags/) and jQuery. Switching between the examples is by changing the entry in the build.sbt to the appropriate name. Since the name of the generated files stays identical, make sure your browser cache is thoroughly emptied. 

## Server

Minimal [Akka](https://akka.io) webserver, servers the main webpage, the javascript file and random numbers upon request. Thus this is an example how to write a minimal webserver as well. Type 'run' on the sbt commandline to start, type 'quit' to stop the server again.

## Client

The client needed to visualize the lucky numbers. Works on the basis of [Akka](http://akka-js.org) too. Yes, Akka in the browser!
