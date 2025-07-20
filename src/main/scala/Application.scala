import akka.actor.typed.ActorSystem
import APIActor.ApiMessage
import akka.actor.typed.scaladsl.{ActorContext,Behaviors}


object Application {

  def main(args: Array[String]): Unit = {

    val system = ActorSystem(ActorSetup() , "myActor")
    val apiActor = system.systemActorOf(APIActor(), "APIActor")

    apiActor ! ApiMessage(name = "renato" , document = "01185983171")

    val apiClassActor = system.systemActorOf(Behaviors.setup {
      new APIClassActor(_: ActorContext[ApiMessage]) }, "APIClassActor"
    )

    apiClassActor ! ApiMessage(name = "renato2" , document = "01185983170")




  }

}
