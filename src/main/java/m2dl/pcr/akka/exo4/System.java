package m2dl.pcr.akka.exo3;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.sys.Prop;


/**
 * Main runtime class.
 */
public class System {

    public static final Logger log = LoggerFactory.getLogger(System.class);

    public static void main(String... args) throws Exception {

        final ActorSystem actorSystem = ActorSystem.create("actor-system");

        Thread.sleep(200);

        final ActorRef crypterRef = actorSystem.actorOf(Props.create(CryptageProviderActor.class), "cryptage-actor");
        final ActorRef recepteurRef = actorSystem.actorOf(Props.create(RecepteurActor.class),"recepteur-actor");
        final ActorRef erreurControlRef = actorSystem.actorOf(Props.create(ErreurControleProviderActor.class),"erreur-control-actor");
        final ActorRef returnCryptageRef = actorSystem.actorOf(Props.create(ReturnCryptageActor.class,erreurControlRef,recepteurRef),"temp-actor");

        Param messageSimpleCrypter = new Param("join",recepteurRef);
        Param messageSimpleError = new Param("je gere les erreur",recepteurRef);
        Param messageWithAllState = new Param("je suis le message pour tout",returnCryptageRef);
//        crypterRef.tell(messageSimpleCrypter,null);
//        erreurControlRef.tell(messageSimpleError,null);
        crypterRef.tell(messageWithAllState,null);
        Thread.sleep(200);

        log.debug("Actor System Shutdown Starting...");

        actorSystem.terminate();
    }
}
