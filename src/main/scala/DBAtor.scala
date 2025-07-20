import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors

object DBAtor {

  case class DBMessage(name: String , document: String)
  def apply(): Behavior[DBMessage] = Behaviors.receive {
    (ctx, msg) =>
        ctx.log.info(s" [CORE] message $msg received ")
        Behaviors.same
  }
}
