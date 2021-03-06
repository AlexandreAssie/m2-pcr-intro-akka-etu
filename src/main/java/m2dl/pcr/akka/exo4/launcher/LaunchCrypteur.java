package m2dl.pcr.akka.exo4.Launcher;

import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;
import m2dl.pcr.akka.exo4.CrypteurActor;

public class LaunchCrypteur {

    public static void main(String[] args) {
        final ActorSystem actorSystem = ActorSystem.create("launchCrypteurSystem", ConfigFactory.load("crypteur"));
        actorSystem.actorOf(Props.create(CrypteurActor.class), "crypteurActor");
    }

}
