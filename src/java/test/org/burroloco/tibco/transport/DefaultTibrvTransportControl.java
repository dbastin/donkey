package org.burroloco.tibco.transport;

import edge.com.tibco.tibrv.TibrvMsg;
import edge.com.tibco.tibrv.TibrvTransport;
import junit.framework.Assert;

public class DefaultTibrvTransportControl implements TibrvTransportControl, TibrvTransport {
    private TibrvMsg msg;

    public void set(TibrvMsg msg) {
        this.msg = msg;
    }

    public String createInbox() {
        throw new RuntimeException();
    }

    public void send(TibrvMsg message) {
        if (msg != null)
            Assert.assertEquals(msg.toString(), message.toString());
    }

    public void destroy() {
        
    }
}
