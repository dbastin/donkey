package org.burroloco.test.butcher.fixture.checker.stream;

import edge.java.io.OutputStream;

public interface StreamChecker {
    void check(OutputStream out, String... expectations);
}
