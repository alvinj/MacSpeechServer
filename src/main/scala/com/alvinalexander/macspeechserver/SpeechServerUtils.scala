package com.alvinalexander.macspeechserver

import com.alvinalexander.applescript.AppleScriptUtils
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

object SpeechServerUtils {

    val scriptEngineManager = new ScriptEngineManager
    val appleScriptEngine = scriptEngineManager.getEngineByName("AppleScript")
    
    // TODO log this instead
    if (appleScriptEngine == null) System.err.println("appleScriptEngine is null, about to fail")

    def endOfParagraphDelay { Thread.sleep(Resources.END_OF_PARAGRAPH_DELAY) }
    def endOfSentenceDelay  { Thread.sleep(Resources.END_OF_SENTENCE_DELAY) }
    def semiColonPause      { Thread.sleep(Resources.SEMI_COLON_PAUSE) }

    def speakWithDelay(sentence: String, voice: String = Resources.ALEX_VOICE) {
        speak(sentence, voice)
        Thread.sleep(Resources.END_OF_SENTENCE_DELAY)
    }

    def speak(sentence: String, voice: String = Resources.ALEX_VOICE) {
        val thingToSay = "say \"%s\" using \"%s\"".format(sentence, voice)
        try {
            appleScriptEngine.eval(thingToSay)
        } catch {
            case e: ScriptException => // TODO
        }
    }

}





