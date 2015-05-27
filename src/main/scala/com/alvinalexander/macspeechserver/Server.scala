package com.alvinalexander.macspeechserver

import akka.actor.Actor
import akka.actor.ActorLogging
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef

// this works (headless on Mac)
// (1) compile/package with sbt-assembly
// (2) run like this:
// java -classpath target/scala-2.10/WikiReaderServer-assembly-0.1.jar -Dapple.awt.UIElement=true com.alvinalexander.wikireaderserver.Server
//
// see http://web.archiveorange.com/archive/v/Hd19lAcrkdsJEtZmYiiQ
//
object Server extends App {

    val system = ActorSystem("MacSpeechServer")
    val sentenceSpeaker = system.actorOf(Props[SentenceSpeaker], name = "SentenceSpeaker")
    sentenceSpeaker ! "The Mac Speech Server is alive."

}

/**
 * All this class does is speak the sentence it is given,
 * with the voice it is given. After the sentence is spoken, it sends a message
 * back to its parent telling the parent it is finished.
 * 
 * TODO let the user set the speaker volume
 * TODO let the user set the speaker cadence
 */
class SentenceSpeaker extends Actor {

    // TODO how to do this without a null?
    var client: ActorRef = _

    def receive = {

        case SpeakSentence(sentence, voice) =>
             client = sender
             speakSentence(sentence, voice)

        case sentence: String =>
             client = sender
             speakSentence(sentence)

        case _ =>
            println("The speech server got an unexpected message.")

    }

    def speakSentence(sentence: String, voice: String = Resources.ALEX_VOICE) {
        SpeechServerUtils.speak(sentence, voice)
        client ! SentenceSpeakerFinishedSpeaking
    }

}







