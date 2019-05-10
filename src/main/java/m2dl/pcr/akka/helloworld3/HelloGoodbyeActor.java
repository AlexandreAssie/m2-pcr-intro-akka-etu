package m2dl.pcr.akka.helloworld3;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Procedure;
/*
1 . Les états de l'ateur
2 . retourner a l'etat de base
3 . Changer l'état pour le prochain comportement
*/

public class HelloGoodbyeActor extends UntypedActor {
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    public HelloGoodbyeActor() {
        log.info("HelloGoodbyeActor constructor");
    }

    Procedure<Object> hello = new Procedure<Object>() {
        public void apply(Object msg) throws Exception {
            if (msg instanceof String) {
                log.info("Hello " + msg + "!");
                getContext().become(goodbye,false);
            } else {
                unhandled(msg);
            }
        }
    };

    Procedure<Object> goodbye = new Procedure<Object>() {
        public void apply(Object msg) throws Exception {
            if (msg instanceof String) {
                log.info("Good bye " + msg + "!");
                getContext().unbecome();
            } else {
                unhandled(msg);
            }
        }
    };

    @Override
    public void onReceive(Object msg) throws Exception {
        hello.apply(msg);
    }


}
