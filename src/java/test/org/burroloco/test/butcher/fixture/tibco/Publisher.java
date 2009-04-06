package org.burroloco.test.butcher.fixture.tibco;

import edge.com.tibco.tibrv.TibrvMsg;

import java.util.Map;

public interface Publisher {
    void send(String subject, Map<String, Object> payload);

    void send(TibrvMsg msg);
}
