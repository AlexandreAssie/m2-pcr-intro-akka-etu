package m2dl.pcr.akka.cribleEratosthene;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Procedure;

public class InterActor extends UntypedActor {
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    private Integer p;
    private ActorRef boutActorRef;

    public InterActor(Integer p) {
        this.log = log;
        this.p = p;
        boutActorRef = null;
        log.info(p.toString());
    }

    Procedure<Object> bout = new Procedure<Object>() {
        public void apply(Object msg) throws Exception {
            if(msg instanceof Integer){
                if(0 != ((Integer) msg % p)){
                   boutActorRef = getContext().actorOf(Props.create(InterActor.class,msg),"test");
                    getContext().become(inter, false);
                    boutActorRef.tell(msg,getSelf());
                }
            }else{
                unhandled(msg);
            }
        }
    };

    Procedure<Object> inter = new Procedure<Object>() {
        public void apply(Object msg) throws Exception {
            if(msg instanceof Integer){
                if(((Integer) msg % p) != 0){
                    boutActorRef.tell(msg, getSelf());
                }
            }else{
                unhandled(msg);
            }
        }
    };

    public void onReceive(Object msg) throws Exception {
        bout.apply(msg);
    }
}
