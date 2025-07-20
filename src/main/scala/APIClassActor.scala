import APIActor.ApiMessage
import DBAtor.DBMessage
import akka.actor.typed.{ActorRef, Behavior}
import akka.actor.typed.scaladsl.{AbstractBehavior, ActorContext, Behaviors}


class APIClassActor(context: ActorContext[ApiMessage]) extends AbstractBehavior(context){

  var db: ActorRef[DBMessage] = context.spawn(Behaviors.setup {
     new DbContext((_: ActorContext[DBMessage]))
  }, "DBClassActor")


  override def onMessage(msg: ApiMessage): Behavior[ApiMessage] = msg match {
    case ApiMessage(name, document) =>
       context.log.info(s"mensagem ${name}-${document} recebida e enviada para a DB!")
       db ! DBMessage(name, document)
       this
  }
}
