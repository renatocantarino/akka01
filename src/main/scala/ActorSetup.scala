import akka.NotUsed
import akka.actor.typed.{Behavior,Terminated}
import akka.actor.typed.scaladsl.Behaviors

object ActorSetup {

  def apply(): Behavior[NotUsed] = Behaviors.setup {
    _ =>
      Behaviors.receiveSignal {
        case (_, Terminated(_)) =>
          Behaviors.stopped
      }
  }

}
