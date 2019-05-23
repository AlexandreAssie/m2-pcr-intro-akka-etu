package m2dl.pcr.akka.exo3;

import akka.actor.ActorRef;
import akka.actor.dsl.Creators;

import java.io.Serializable;

public class Param implements Serializable {

    private String message;

    private ActorRef reference;

    public Param(String message, ActorRef reference) {
        this.message = message;
        this.reference = reference;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ActorRef getReference() {
        return reference;
    }

    public void setReference(ActorRef reference) {
        this.reference = reference;
    }
}
