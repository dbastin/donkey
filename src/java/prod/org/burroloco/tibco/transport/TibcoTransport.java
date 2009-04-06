package org.burroloco.tibco.transport;

import edge.com.tibco.tibrv.TibrvMsg;
import edge.com.tibco.tibrv.TibrvTransport;

public interface TibcoTransport {
    String createInbox();

    void send(TibrvMsg message);

    TibrvTransport tibby();
}
