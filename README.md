Mac Speech Server
=================

This project runs on Mac OS X systems. You can send text strings to this "server,"
and it will "read" the text on your Mac system by using the AppleScript `say` command.
If you happen to be using an Akka client, the system can also tell you when it's
finished speaking, and you can also cancel the speaking process (such as if it's in
the middle of a long blurb, and you don't want to hear any more of it).

This project started out as the server component of my Wikipedia "reader" application.


Motivation
----------

I had the following motivations for creating this project:

1. I use "speech to text" technology in several Scala/Java projects.
1. Trying to get AppleScript to work with Java/Scala on Mac OS X can be a pain.
1. You need to use any "speech to text" AppleScript in a separate JVM, or your main
   JVM will get bogged down while doing the speaking. I don't know why, but the entire
   JVM becomes unresponsive when you issue the AppleScript `say` command/method.


Building the Server
-------------------

I need to update this process, but the current build process is managed through a series
of shell scripts. I created these scripts based on my needs during the development process,
and I need to improve how I do some things.

Here's a little description of each script:

* _assemble-run.sh_ builds a single jar file with sbt-assembly and then
  runs that jar file
* _package.sh_ builds the single jar file
* _run-jars.sh_ runs the existing jar file

Those jar files need to be refactored because they have redundant
information in them, but they do work.

License
-------

This software is released under the licensing terms of the 
GNU GPL Version 3. See the accompanying LICENSE file for more
details.



