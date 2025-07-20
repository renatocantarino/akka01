import APIActor.ApiMessage
import akka.actor.typed.ActorSystem


object Application {

  def main(args: Array[String]): Unit = {

    val system = ActorSystem(ActorSetup() , "myActor")
    val apiActor = system.systemActorOf(APIActor(), "APIActor")

    apiActor ! ApiMessage(name = "renato" , document = "01185983171")
  }

}
