package m2dl.pcr.akka.cribleEratosthene;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import m2dl.pcr.akka.exo12.ParentActor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.ranges.Range;

import javax.management.openmbean.ArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


/**
 * Main runtime class.
 */
public class System {

    public static final Logger log = LoggerFactory.getLogger(System.class);

    public static void main(String... args) throws Exception {

        final ActorSystem actorSystem = ActorSystem.create("actor-system");

        Thread.sleep(200);

        final ActorRef actorRef = actorSystem.actorOf(Props.create(InterActor.class, 3), "inter-actor");

        IntStream.range(3,30).forEach(
                i-> {actorRef.tell(i,null);}
        );
        Thread.sleep(1000);

        log.debug("Actor System Shutdown Starting...");

        actorSystem.terminate();
    }
}
