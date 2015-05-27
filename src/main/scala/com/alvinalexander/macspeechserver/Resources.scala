package com.alvinalexander.macspeechserver

object Resources {

    // male voices
    val ALEX_VOICE     = "Alex"
    val DANIEL_VOICE   = "Daniel"
    val LEE_VOICE      = "Lee"
    val OLIVER_VOICE   = "Oliver"

    // female voices
    val FIONA_VOICE    = "Fiona"
    val MOIRA_VOICE    = "Moira"
    val KAREN_VOICE    = "Karen"
    val KATE_VOICE     = "Kate"
    val SAMANTHA_VOICE = "Samantha"
    val SUSAN_VOICE    = "Susan"
    val VICKI_VOICE    = "Vicki"

    // speaking delays (ms)
    val END_OF_PARAGRAPH_DELAY = 1000  // was 1000
    val END_OF_SENTENCE_DELAY = 150    // was 250
    val SEMI_COLON_PAUSE = 400         // was 400

}

/**
 * in theory everything below here is something that both the Server and Clients need
 */

case class SpeakSentence(sentence: String, voice: String = "Alex")

//case class SpeakParagraphs(paragrahs: Seq[String], voice: String = "Alex")
//case class SpeakParagraphsWithMultipleVoices(paragrahs: Seq[String], voices: Seq[String])

/**
 * a client can/will get this message back from the server when it's finished speaking
 */
case object SentenceSpeakerFinishedSpeaking

/**
 * TODO: send this message to the server to get it to stop speaking
 */
//case object StopSpeaking





