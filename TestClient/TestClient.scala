package testclient

import akka.actor._

object TestClient extends App {

    val START_MSG = "START"

    implicit val actorSystem = ActorSystem("TestClient")
    val localActor = actorSystem.actorOf(Props[ClientActor], name = "ClientActor")  // the local actor
    localActor ! START_MSG

}

class ClientActor extends Actor {

    // create the remote actor
    val sentenceSpeaker = context.actorFor("akka://MacSpeechServer@127.0.0.1:5150/user/SentenceSpeaker")

    def receive = {
        case TestClient.START_MSG => 
             sentenceSpeaker ! "Hello from the test client."
      //case _ =>
      //     sentenceSpeaker ! "Got something else"
    }

}

