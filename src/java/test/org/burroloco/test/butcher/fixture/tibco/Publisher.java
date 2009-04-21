package org.burroloco.test.butcher.fixture.tibco;

import java.util.Map;

public interface Publisher {
    void send(String subject, Map<String, Object> payload);
}
