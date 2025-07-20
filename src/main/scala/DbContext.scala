import DBAtor.DBMessage
import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.AbstractBehavior
import akka.actor.typed.scaladsl.ActorContext

class DbContext(context: ActorContext[DBMessage]) extends AbstractBehavior(context) {

  override def onMessage(msg: DBMessage): Behavior[DBMessage] = msg match {
    case DBMessage(name,document) =>
      context.log.info(s"[DB says => ] message $msg received and stored")
      this
  }
}
