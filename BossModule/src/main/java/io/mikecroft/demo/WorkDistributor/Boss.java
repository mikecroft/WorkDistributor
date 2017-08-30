package io.mikecroft.demo.WorkDistributor;

import fish.payara.micro.cdi.Outbound;
import java.time.Instant;
import java.util.logging.Logger;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 *
 * @author Mike Croft
 */
@Singleton
@Startup
public class Boss {

    static Logger logger = Logger.getLogger(Boss.class.getCanonicalName());

    @Inject
    @Outbound(eventName = "serf")
    Event<WorkRequest> serf;

    @Inject
    @Outbound(eventName = "lackey")
    Event<WorkRequest> lackey;

    @Inject
    @Outbound(eventName = "dogsbody")
    Event<WorkRequest> dogsbody;

    @Schedule(hour = "*", minute = "*", second = "*", info = "Work Generator", timezone = "UTC", persistent = false)
    public void sendWork() {

        Long now = Instant.now().getEpochSecond();

        if (now % 2 == 0) {
            serf.fire(WorkRequest.TARTAN_PAINT);
        } else if (now % 3 == 0) {
            lackey.fire(WorkRequest.LONG_STAND);
        } else {
            dogsbody.fire(WorkRequest.BUSYWORK);
        }

    }

}
