package org.burroloco.test.butcher.fixture.tibco;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.com.tibco.tibrv.TibrvMsg;
import edge.com.tibco.tibrv.TibrvRvdTransport;
import org.burroloco.tibco.config.TibcoParameters;

import java.util.Map;

// FIX TSR-DONKEY Lose or Use this in Tibco2FileDemoTest
public class DefaultPublisher implements Publisher {
    TibcoParameters tibco;
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
        String service = tibco.service();
        String network = tibco.network();
        String daemon = tibco.daemon();
        TibrvRvdTransport transport = nu.nu(TibrvRvdTransport.class, service, network, daemon);
        transport.send(m);
    }
}
