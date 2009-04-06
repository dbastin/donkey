package org.burroloco.tibco.transport;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.com.tibco.tibrv.TibrvListener;
import edge.com.tibco.tibrv.TibrvMsg;
import edge.com.tibco.tibrv.TibrvTransport;

public class DefaultTibcoPublisher implements TibcoPublisher {
    Nu nu;

    public void send(TibrvListener listener, TibrvMsg msg) {
        TibcoTransport transport = transport(listener);
        transport.send(msg);
    }

    private TibcoTransport transport(TibrvListener listener) {
        TibrvTransport tibby = listener.getTransport();
        return nu.nu(TibcoTransport.class, tibby);
    }
}
