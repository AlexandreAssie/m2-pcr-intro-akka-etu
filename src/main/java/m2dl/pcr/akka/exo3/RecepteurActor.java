package m2dl.pcr.akka.exo3;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import m2dl.pcr.akka.stringservices.StringUtils;

public class RecepteurActor extends UntypedActor {

    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    @Override
    public void onReceive(Object o) throws Exception {
        Param param = (Param) o;
        String message = param.getMessage();
        log.info(StringUtils.crypte(StringUtils.verifieCtrl(message)));

    }
}
