package m2dl.pcr.akka.exo3;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import m2dl.pcr.akka.stringservices.StringUtils;

public class CryptageProviderActor extends UntypedActor {

    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    @Override
    public void onReceive(Object msg) throws Exception {
        Param param = (Param) msg;
        Param paramRetour = new Param(StringUtils.crypte(param.getMessage()),null);
        param.getReference().tell(paramRetour,param.getReference());


    }
}
