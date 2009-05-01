package org.burroloco.donkey.input.http;

import edge.javax.servlet.http.HttpServletRequest;

public interface TrapDoor {
    void handleRequest(HttpServletRequest request);
}
