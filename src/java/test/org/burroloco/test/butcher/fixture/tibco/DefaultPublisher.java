package org.burroloco.test.butcher.fixture.tibco;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.com.tibco.tibrv.TibrvMsg;
import edge.com.tibco.tibrv.TibrvRvdTransport;
import org.burroloco.tibco.config.Daemon;
import org.burroloco.tibco.config.Network;
import org.burroloco.tibco.config.Service;

import java.util.Map;

public class DefaultPublisher implements Publisher {
    Service service;
    Network network;
    Daemon daemon;
    Weaken weaken;
    Nu nu;

    public void send(String subject, Map<String, Object> payload) {
        TibrvMsg m = message(subject, payload);
        whooooooooooosh(m);
    }

    public void send(TibrvMsg msg) {
        whooooooooooosh(msg);
    }

    private TibrvMsg message(String subject, Map<String, Object> payload) {
        TibrvMsg m = nu.nu(TibrvMsg.class);
        m.setSendSubject(subject);
        for (String key : payload.keySet()) {
            m.add(key, payload.get(key));
        }
        return m;
    }

    private void whooooooooooosh(TibrvMsg m) {
        String s = weaken.w(service);
        String n = weaken.w(network);
        String d = weaken.w(daemon);
        TibrvRvdTransport transport = nu.nu(TibrvRvdTransport.class, s, n, d);
        transport.send(m);
    }
}
