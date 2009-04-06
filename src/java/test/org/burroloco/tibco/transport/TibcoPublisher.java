package org.burroloco.tibco.transport;

import edge.com.tibco.tibrv.TibrvListener;
import edge.com.tibco.tibrv.TibrvMsg;

public interface TibcoPublisher {
    void send(TibrvListener listener, TibrvMsg msg);
}
