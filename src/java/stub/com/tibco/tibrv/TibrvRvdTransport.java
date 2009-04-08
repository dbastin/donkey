package com.tibco.tibrv;

public class TibrvRvdTransport extends TibrvTransport {
    public TibrvRvdTransport(String service, String network, String daemon) {
    }

    public void send(TibrvMsg msg) {
        System.out.println("msg = " + msg);
    }

    public void destroy() {}
}
