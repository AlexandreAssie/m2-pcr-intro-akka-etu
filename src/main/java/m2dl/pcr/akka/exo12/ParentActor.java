package m2dl.pcr.akka.exo12;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.japi.Procedure;

public class ParentActor extends UntypedActor {

    private ActorRef helloActorRef;
    private ActorRef goodbyeActorRef;

    public void onReceive(Object msg) throws Exception {
        hello.apply(msg);
    }

    public ParentActor() {
        helloActorRef = getContext().actorOf(Props.create(HelloActor.class),"hello-actor");
        goodbyeActorRef = getContext().actorOf(Props.create(GoodbyeActor.class),"goodbye-actor");
    }

  Procedure<Object> hello = new Procedure<Object>() {
        public void apply(Object msg) throws Exception {
            helloActorRef.tell(msg,getSelf());
            getContext().become(goodbye,false);
        }
    };

    Procedure<Object> goodbye = new Procedure<Object>() {
        public void apply(Object msg) throws Exception {
            goodbyeActorRef.tell(msg,getSelf());
            getContext().become(hello,false);
        }
    };
}
