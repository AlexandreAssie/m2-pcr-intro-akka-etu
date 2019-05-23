package m2dl.pcr.akka.exo4.Launcher;

import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;
import m2dl.pcr.akka.exo4.ErreurActor;

public class LaunchErreur {

    public static void main(String[] args) {
        final ActorSystem actorSystem = ActorSystem.create("launchErreurSystem", ConfigFactory.load("erreur"));
        actorSystem.actorOf(Props.create(ErreurActor.class), "erreurActor");
    }

}
