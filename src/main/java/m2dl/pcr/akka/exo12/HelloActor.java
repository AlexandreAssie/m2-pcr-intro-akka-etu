package m2dl.pcr.akka.exo12;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class HelloActor extends UntypedActor {
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    public void onReceive(Object msg) throws Exception {
        if(msg instanceof String) {
            log.info("Hello " + msg );
        }else{
            unhandled(msg);
        }
    }
}
