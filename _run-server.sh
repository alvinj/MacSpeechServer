#!/bin/sh

OUTPUT_JAR=target/scala-2.10/MacSpeechServer-assembly-0.1.jar
MAIN_CLASS=com.alvinalexander.macspeechserver.Server

java -classpath $OUTPUT_JAR -Dapple.awt.UIElement=true $MAIN_CLASS

