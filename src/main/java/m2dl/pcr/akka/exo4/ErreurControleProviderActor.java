package m2dl.pcr.akka.exo3;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import m2dl.pcr.akka.stringservices.StringUtils;

public class ErreurControleProviderActor extends UntypedActor {

    LoggingAdapter log = Logging.getLogger(getContext().system(), this);


    @Override
    public void onReceive(Object o) throws Exception {
        Param param = (Param) o;
        param.getReference().tell(new Param(StringUtils.ajouteCtrl(param.getMessage()),null),param.getReference());
    }
}
