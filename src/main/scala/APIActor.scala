import DBAtor.DBMessage
import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors

object APIActor {

  case class ApiMessage(name:String, document:String)

  def apply(): Behavior[ApiMessage] = Behaviors.setup { ctx =>
    val refActorDB = ctx.spawn(DBAtor(), "DBAtor")

    Behaviors.receive{
      (ctx , msg) =>
        ctx.log.info(s"[API] message $msg received and sended to DB ")
        refActorDB ! DBMessage(name = msg.name, document = msg.document)
        Behaviors.same

    }

  }



}
