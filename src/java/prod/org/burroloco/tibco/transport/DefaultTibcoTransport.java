package org.burroloco.tibco.transport;

import au.net.netstorm.boost.bullet.log.Log;
import edge.com.tibco.tibrv.TibrvMsg;
import edge.com.tibco.tibrv.TibrvTransport;

public class DefaultTibcoTransport implements TibcoTransport {
    private final TibrvTransport tibby;
    Log log;

    public DefaultTibcoTransport(TibrvTransport tibby) {
        this.tibby = tibby;
    }

    public String createInbox() {
        return tibby.createInbox();
    }

    public void send(TibrvMsg message) {
        log.trace("Sending to " + message.getSendSubject() + ": " + message);
        tibby.send(message);
    }

    public TibrvTransport tibby() {
        return tibby;
    }
}
