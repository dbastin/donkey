package org.burroloco.test.butcher.fixture.tibco;

import edge.java.io.OutputStream;

public interface WireTap {
    void start(OutputStream out);

    void stop();
}
