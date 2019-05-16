package m2dl.pcr.akka.exo3;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import m2dl.pcr.akka.stringservices.StringUtils;

public class ReturnCryptageActor extends UntypedActor {

    LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    //recupere le recepteur
    private ActorRef erreurControleActorRef;
    private ActorRef referenceActorRef;

    public ReturnCryptageActor(ActorRef erreurControleActorRef, ActorRef referenceActorRef) {
        this.erreurControleActorRef = erreurControleActorRef;
        this.referenceActorRef = referenceActorRef;
    }

    @Override
    public void onReceive(Object o) throws Exception {
        Param param = (Param) o;;
        erreurControleActorRef.tell(new Param(param.getMessage(),referenceActorRef),self());

    }
}
