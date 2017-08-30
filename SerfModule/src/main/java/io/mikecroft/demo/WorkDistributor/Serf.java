package io.mikecroft.demo.WorkDistributor;

import fish.payara.micro.cdi.Inbound;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.event.Observes;

/**
 *
 * @author Mike Croft
 */
@Singleton
@Startup
public class Serf {

    public void receiveEvent(@Observes @Inbound(eventName = "serf") WorkRequest req) {
        new Work().doWork(req);
    }
}
