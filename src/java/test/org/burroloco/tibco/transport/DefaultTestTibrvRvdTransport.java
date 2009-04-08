package org.burroloco.tibco.transport;

import edge.com.tibco.tibrv.TibrvMsg;

public class DefaultTestTibrvRvdTransport implements TestTibrvRvdTransport {
    private TibrvMsg msg;

    public DefaultTestTibrvRvdTransport(String s, String n, String d) { }

    public String createInbox() {
        throw new RuntimeException();
    }

    public void send(TibrvMsg message) {
        msg = message;
    }

    public void destroy() {
    }

    public TibrvMsg get() {
        return msg;
    }
}
